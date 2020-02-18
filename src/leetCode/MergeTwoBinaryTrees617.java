package leetCode;

/**
 * Created by d-xsj on 2019/12/8.
 */
public class MergeTwoBinaryTrees617 {

    class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  // 傻逼解法
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if( t1 == null && t2 == null){
            return null;
        }
        if (t1 == null){
            TreeNode ans = new TreeNode(t2.val);
            ans.left = mergeTrees(null, t2.left);
            ans.right = mergeTrees(null, t2.right);
            return ans;
        }
        if (t2 == null){
            TreeNode ans = new TreeNode(t1.val);
            ans.left = mergeTrees(t1, null);
            ans.right = mergeTrees(t1, null);
            return ans;
        }
        TreeNode ans = new TreeNode(t1.val+t2.val);
        ans.left = mergeTrees(t1.left, t2.left);
        ans.right = mergeTrees(t1.right, t2.right);
        return ans;
    }
    // 原理一样，去掉多余的情况，t1或者t2为null，就意味着返回了另一个节点。。。
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
