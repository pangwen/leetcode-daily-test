package rangeSumofBst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * Description: 二叉搜索树范围内所有节点值求和
 * <p>
 * Created on 2021/4/27.
 *
 * @author pangwen
 * @version 0.1
 */
public class RangeSumOfBstSolution {

    public static int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> list = new ArrayList<>();
        inorder(root, low, high, list);
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    private static void inorder(TreeNode node, int low, int high, List<Integer> list) {
        if (node == null) {
            return;
        }
        if(node.val < low){
            inorder(node.right, low, high, list);
        }
        if(node.val > high){
            inorder(node.left, low, high, list);
        }
        if(node.val >= low && node.val <= high){
            list.add(node.val);
            inorder(node.right, low, high, list);
            inorder(node.left, low, high, list);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode rootLeft = new TreeNode(5);
        root.left = rootLeft;
        TreeNode rootRight = new TreeNode(15);
        root.right = rootRight;

        rootLeft.setLeft(new TreeNode(3));
        rootLeft.setRight(new TreeNode(7));

        rootRight.setRight(new TreeNode(18));

        System.out.println(rangeSumBST(root, 7, 15));
    }
}
