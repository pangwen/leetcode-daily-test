package trappingRainWater;

/**
 * <p>
 * Description: 42. 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * </p>
 * <p>
 * Created on 2021/5/7.
 *
 * @author pangwen
 * @version 0.1
 */
public class TrappingRainWaterSolution {

    public static int trap(int[] heights) {
        int len = heights.length;
        if(len < 3){
            return 0;
        }
        int[] leftMax = new int[len];
        leftMax[0] = heights[0];
        int[] rightMax = new int[len];
        rightMax[len -1] = heights[len - 1];
        //左边最大值
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }
        //右边最大值
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }
        int sum = 0;
        //计算每个位置能接的雨水
        for (int i = 1; i < heights.length -1; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] arr2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(arr2));
    }

}
