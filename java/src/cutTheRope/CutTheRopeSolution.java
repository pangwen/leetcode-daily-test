package cutTheRope;

/**
 * <p>
 * Description: 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * <p>
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Created on 2021/5/24.
 *
 * @author pangwen
 * @version 0.1
 */
public class CutTheRopeSolution {

    private static int cuttingRope(int n) {

        if (n <= 3) return n - 1;

        int subCount = n / 3;
        int mod = n % 3;
        long result = 1;
        for (int i = 1; i <= subCount; i++) {
            result *= i < subCount ? 3 : mod < 2 ? 3 + mod : 3 * mod;
            if (result >= 1000000007) {
                result %= 1000000007;
            }
        }
        return (int)result;

    }

    public static void main(String[] args) {
    }

}
