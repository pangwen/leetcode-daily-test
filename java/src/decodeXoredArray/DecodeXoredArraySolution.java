package decodeXoredArray;

import java.util.Arrays;

/**
 * <p>
 * Description: 解码异或后的数组
 * <p>
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 * </p>
 *
 * <p>
 * Created on 2021/5/6.
 *
 * @author pangwen
 * @version 0.1
 */
public class DecodeXoredArraySolution {

    /**
     * @param encoded 异或编码后的数组
     * @param first   原始数组第一个元素
     * @return 原始数组
     */
    public static int[] decode(int[] encoded, int first) {
        int len = encoded.length;
        int[] src = new int[len + 1];
        src[0] = first;
        for (int i = 1; i <= len; i++) {
            src[i] = encoded[i - 1] ^ src[i - 1];
        }

        return src;
    }

    public static void main(String[] args) {
        int[] encoded = {6, 2, 7, 3};
        int first = 4;
        System.out.println(Arrays.toString(decode(encoded, first)));
    }
}
