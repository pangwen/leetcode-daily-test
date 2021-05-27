package robotMoveInMatrix;

/**
 * <p>
 * Description: 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 *
 * 请问该机器人能够到达多少个格子？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Created on 2021/5/24.
 *
 * @author pangwen
 * @version 0.1
 */
public class RobotMoveInMatrixSolution {

    static boolean[][] arrived;

    private  static int moveCount(int m, int n, int k) {
        arrived = new boolean[m][n];
        if (k == 0) {
            return 1;
        }
        dfs(m, n, k, 0, 0);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arrived[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
    private static void dfs(int m, int n, int k, int i, int j){
        if(i < 0 || i >= m || j<0 || j>=n || !canArrive(i, j, k) || arrived[i][j] ){
            return;
        }
        arrived[i][j] = true;
        dfs(m, n, k, i + 1, j);
        dfs(m, n, k, i - 1, j);
        dfs(m, n, k, i, j + 1);
        dfs(m, n, k, i, j - 1);
    }

    private static boolean canArrive( int i, int j, int k){

        return i/10 + i % 10 + j /10 + j % 10 <= k;
    }

    public static void main(String[] args) {
        System.out.println(moveCount(20, 30, 10));
    }
}
