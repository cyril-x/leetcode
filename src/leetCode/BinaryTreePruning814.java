package leetCode;

/**
 * Created by d-xsj on 2019/12/8.
 */

public class BinaryTreePruning814 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
// 后序遍历
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (root.left != null) pruneTree(root.left);
        if (root.right != null) pruneTree(root.right);
        return (root.left == null && root.right == null && root.val == 0) ? null : root;


    }
}
