package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d-xsj on 19/03/2018.
 */
public class BinayTreeRightSideView199 {
    /*
    * 用深搜解决的，从右边往左遍历，遇到这一层第一次遇到的就加到list中
    * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> re = new ArrayList<Integer>();
        dfs(root,0,re);
        return re;
    }
    public void dfs(TreeNode root,int deep,List<Integer> list){
        if(root==null){
            return ;
        }
        if(list.size()==deep){
            list.add(root.val);
        }
        if(root.right!=null){
            dfs(root.right,deep+1,list);
        }
        if(root.left!=null){
            dfs(root.left,deep+1,list);
        }

    }
}
