package num1InBinary;

import org.w3c.dom.ls.LSOutput;

/**
 * <p>
 * Description: todo
 * <p>
 * Created on 2021/5/27.
 *
 * @author pangwen
 * @version 0.1
 */
public class NumInBinarySolution {

    private static String boBinaryStr(int num){
        char[] chars = new char[]{'0', '1'};
        char[] res = new char[32];

        for (int i = 32; i > 0 ; i--) {
            res[i -1] = chars[num & 1];
            num >>= 1;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(10));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 32; i > 0 ; i--) {
            if((n & 1) == 1){
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
