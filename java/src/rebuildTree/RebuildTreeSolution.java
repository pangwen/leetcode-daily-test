package rebuildTree;

import java.util.Arrays;

/**
 * <p>
 * Description: 给定二叉树的前序遍历与中序遍历数组，要求重建二叉树
 * <p>
 * Created on 2021/5/21.
 *
 * @author pangwen
 * @version 0.1
 */
public class RebuildTreeSolution {

    public static void main(String[] args) {
        int [] per = new int[]{1,2,3,4};
        int [] in = new int[]{1,2,3,4};

        TreeNode node = reConstructBinaryTree(per, in);
        System.out.println(node);

    }
    public static TreeNode reConstructBinaryTree(int[] pre, int [] in){
        if (pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        // 根据前序遍历找到根节点： 根 - 左 - 右
        int rootVal = pre[0];
        TreeNode root = new TreeNode(rootVal);
        // 根据中序遍历（左 - 根 - 右），找到 根节点索引， 确定左子树和右子树
        int rootIndex = findIndex(in, rootVal);
        if(rootIndex == -1){
            throw new IllegalStateException();
        }

        //中序左子树
        int[] inLeft = Arrays.copyOfRange(in, 0, rootIndex);
        //前序左子树
        int[] perLeft = Arrays.copyOfRange(pre, 1, rootIndex + 1);
        root.left = reConstructBinaryTree(perLeft, inLeft);

        // 中序右子树
        int[] inRight = Arrays.copyOfRange(in, rootIndex + 1, in.length);
        // 前序右子树
        int[] perRight = Arrays.copyOfRange(pre, rootIndex + 1, in.length);
        root.right = reConstructBinaryTree(perRight, inRight);

        return root;
    }


    private static int findIndex(int[] in, int rootVal) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

