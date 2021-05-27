package findWordInMatrix;

/**
 * <p>
 * Description: 给定一个m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * Created on 2021/5/24.
 *
 * @author pangwen
 * @version 0.1
 */
public class FindWordInMatrixSolution {

    public static boolean exists(char[][] board, String word) {
        /*
         *  题解：动态规划 + 剪枝
         *  深度优先搜索，暴力遍历二维数组中所有字符可能性，通过一个方向搜到底，再回溯至上一个节点，沿另一个方向搜索，以此类推。
         *  剪枝：在搜索中，如果超出边界board边界，或者字符与 word[index] 不匹配， 或者已经搜索过则直接返回 false。
         */
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word.toCharArray(), i, j, 0))
                    return true;
            }
        }
        return false;
    }

    /**
     * 动态规划，递归搜索
     *
     * @param board 字符矩阵
     * @param words 搜索字符数组
     * @param i     board一维索引
     * @param j     board二维索引
     * @param k     搜索字符索引
     * @return 搜索结果
     */
    private static boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i >= board.length
                || i < 0
                || j >= board[0].length
                || j < 0
                || board[i][j] != words[k])
            return false;
        //如果已搜索字符长度与指定字符长度相等，则说明已经完全匹配
        if (k == words.length - 1) return true;

        //将已搜索字符置空， 避免重复匹配
        board[i][j] = '\0';

        //向各个方向递归
        boolean res = dfs(board, words, i + 1, j, k + 1)
                || dfs(board, words, i - 1, j, k + 1)
                || dfs(board, words, i, j + 1, k + 1)
                || dfs(board, words, i, j - 1, k + 1);

        // 递归完成后，还原字符
        board[i][j] = words[k];
        return res;
    }

}
