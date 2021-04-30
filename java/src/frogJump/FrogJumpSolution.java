package frogJump;

import java.util.*;

/**
 * <p>
 * Description: 青蛙过河
 * <p>
 * Created on 2021/4/29.
 *
 * @author pangwen
 * @version 0.1
 */
public class FrogJumpSolution {

    /**
     * 状态记录
     */
    private static Boolean[][] rec;
    private static Map<Integer, Integer> map;

    public static boolean canCross(int[] stones) {
        final int len = stones.length;
        rec = new Boolean[len][len];

        //将石头数组转换为 hash map， 方便查找
        map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            map.put(stones[i], i);
        }

        //下一跳的状态
        return dfs(stones, 1, 1);
    }

    /**
     * 深度优先搜索： Depth First Search
     *
     * @param stones   石头数组
     * @param curIndex 当前石头索引
     * @param lastDis  上一次跳跃距离
     * @return 是否到达终点
     */
    private static boolean dfs(int[] stones, int curIndex, int lastDis) {
        int len = stones.length;
        /*
         如果当前所在石头位置到达数组最后一个石头,过河成功
         */
        if (curIndex == len - 1) {
            return true;
        }
        //检查石头是否已经跳跃，如果已经跳跃则返回上次结果
        if (rec[curIndex][lastDis] != null) {
            //递归到已走过路线
            System.out.println("使用到计算结果： curIndex:" + curIndex + ", lastDis:" + lastDis);
            return rec[curIndex][lastDis];
        }
        //判断是否能到达下一个石头
        for (int curDis = lastDis - 1; curDis <= lastDis + 1; curDis++) {
            if (curDis < 1) {
                continue;
            }
            Integer nextIndex = map.get(stones[curIndex] + curDis);
            //成功找到下一个石头
            if (nextIndex != null) {
                if (dfs(stones, nextIndex, curDis)) {
                    //System.out.println("index:" + curIndex + ", curStone: " + stones[curIndex] + ",lastDis:" + curDis);
                    return rec[curIndex][curDis] = true;
                }
            }
        }
        //未找到下一个石头
        return rec[curIndex][lastDis] = false;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
//        int[] stones1 = {0, 1, 2, 3, 4, 6, 8, 9, 11, 13, 15, 19, 22};
        long s = System.currentTimeMillis();
        System.out.println(canCross(stones));
        System.out.println(System.currentTimeMillis() - s);

        for (int i = 0; i < rec.length; i++) {
            for (int j = 0; j < rec.length; j++) {
                if(Objects.nonNull(rec[i][j]))
                System.out.println("rec[" + i + "][" + j + "]:" + rec[i][j]);
            }
        }

    }

}
