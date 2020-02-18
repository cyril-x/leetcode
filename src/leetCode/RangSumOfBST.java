package leetCode;

/**
 * Created by d-xsj on 2019/12/8.
 */
public class RangSumOfBST {

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }
    int count = 0;
// 中序遍历
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null){
            return 0;
        }
        if (root.val > L && root.left != null){
            rangeSumBST(root.left,L,R);
        }
        if (root.val >= L && root.val <= R){
            count += root.val;
        }
        if (root.val < R && root.right != null){
            rangeSumBST(root.right,L,R);
        }
        return count;
    }


}
