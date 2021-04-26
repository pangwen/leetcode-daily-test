package shipPackage;

import java.util.Arrays;

/**
 * <p>
 * Description: 在 D 天内送达包裹的能力
 * <p>
 * Created on 2021/4/26.
 *
 * @author pangwen
 * @version 0.1
 */
public class ShipPackageSolution {

    /**
     * 求在 D 天内送达包裹的最低能力
     *
     * @param weights 包裹重量数组
     * @param D       指定运输天数
     * @return 最低运送能力
     */
    public static int shipWithinDays(int[] weights, int D) {

        int max = 0;
        int sum = 0;

        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }

        int left = max;
        int right = sum;

        while (left < right) {
            int mid = (left + right) >> 1;
            int current = 0;
            int need = 1;
            for (int weight : weights) {
                current += weight;
                if (current > mid) {
                    need++;
                    current = weight;
                }
            }
            if (need > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 2, 4, 1, 4};
        int D = 3;

        System.out.println(shipWithinDays(weights, D));

    }
}
