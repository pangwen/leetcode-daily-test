package xoredOperationInAnArray;

/**
 * <p>
 * Description: 1486. 数组异或操作
 * <ol>
 *     <P>给你两个整数，n 和 start 。</p>
 *     <p>数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。</p>
 *     <p>请返回 nums 中所有元素按位异或（XOR）后得到的结果。</p>
 * </ol>
 * <p>
 * Created on 2021/5/7.
 *
 * @author pangwen
 * @version 0.1
 */
public class XoredOperationInArraySolution {

    public static int xorOperation(int n, int start) {

        int result = start;
        for (int i = 1; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(xorOperation(10,5));
    }
}
