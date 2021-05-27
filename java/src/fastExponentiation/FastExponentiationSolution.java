package fastExponentiation;

/**
 * <p>
 * Description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 提示：
 * <p>
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31 -1
 * -10^4 <= x^n <= 10^4
 *
 * <p>
 * Created on 2021/5/27.
 *
 * @author pangwen
 * @version 0.1
 */
public class FastExponentiationSolution {

    /**
     * 需要使用快速幂解法，将 n 展开为2进制展开式： b0 * 2^0 +  b1 * 2^1 + b2 * 2^2 + ... + bm * 2^m
     * x ^ n = x * x^2 * x^4 * x^8 * ... * x^2^m
     *
     * @param x 底数
     * @param n 幂
     * @return 计算结果
     */
    public static double myPow(double x, int n) {
        if (x == 1 || n == 0) return 1;

        long m = n;
        if (n < 0) {
            x = 1 / x;
            m = -m;
        }
        double res = 1.0;
        while (m > 0) {
            if ((m & 1) == 1) {
                res *= x;
            }
            m >>= 1;
            x = x * x;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(0-(Integer.MIN_VALUE));
    }
}
