package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by d-xsj on 18/03/2018.
 */
public class FindLargestValueinEachTreeRow515 {
    /*
    * 非递归解法，利用队列进行层次遍历同时选出最大值，广度优先
    *
    * */
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> re = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null){
            return re;
        }

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while(size--!=0){
                TreeNode temp = queue.poll();
                max = Math.max(max,temp.val);
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);

                }
            }
            re.add(max);
        }

        return re;

    }

    /*
    * 递归解法，深度优先
    * 用一个depth标注深度，先遍历左子树，之后遍历又子树
    * */

    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode root, int depth, List<Integer> res){
        if(root == null) return;
        if(depth == res.size()){
            res.add(root.val);
        } else {
            res.set(depth, Math.max(res.get(depth), root.val));
        }
        helper(root.left, depth + 1, res);
        helper(root.right, depth + 1, res);
    }
}
