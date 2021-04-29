package sumOfSquareNumbers;

/**
 * <p>
 * Description: 判断是否存在两个数 a<sup>2</sup> + b<sup>2</sup> = c
 * <p>
 * Created on 2021/4/29.
 *
 * @author pangwen
 * @version 0.1
 */
public class Solution {

    public static boolean judgeSquareSum(int c){
        int sqrt = (int)Math.sqrt(c);
        for (int a = 0, b = sqrt; a <= b;) {
            if(a * a + b * b < c){
                a++;
            }else if(a * a + b * b > c){
                b--;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int c = 2147483644;
        long begin = System.currentTimeMillis();
        System.out.println(judgeSquareSum(c));
        System.out.println(System.currentTimeMillis() - begin);
    }
}
