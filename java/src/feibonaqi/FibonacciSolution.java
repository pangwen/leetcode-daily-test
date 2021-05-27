package feibonaqi;

/**
 * <p>
 * Description: 求斐波那契数列第 n 项的值。 数列从 0 开始，索引为0.
 * <p>
 * Created on 2021/5/24.
 *
 * @author pangwen
 * @version 0.1
 */
public class FibonacciSolution {
    private static  int fib(int n) {
        if(n < 2){
            return n;
        }
        int rn = -1;

        int r0 = 0;
        int r1 = 1;
        for(int i = 2; i <= n; i++){
            rn = r0 + r1;
            // 大数取模
            if(rn > 1e9 + 7){
                rn %= 1e9+7;
            }
            System.out.print(rn + ",");
            if(i % 10 == 0){
                System.out.println();
            }
            r0 = r1;
            r1 = rn;
        }
        return rn;
    }

    public static void main(String[] args) {
        fib(1000);
    }
}
