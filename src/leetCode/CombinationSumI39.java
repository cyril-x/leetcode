package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d-xsj on 22/12/2017.
 */
public class CombinationSumI39 {
    /**
     * 典型的回溯解法，对Java的编写能力还是不够啊
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        //Arrays.sort(candidates);
        List re = new ArrayList<ArrayList<Integer>>();
        List temp = new ArrayList<Integer>();
        find(candidates,0,target,re,temp);


        return re;

    }

    public void find(int[] nums,int start , int target,List<List<Integer>> re,List<Integer> temp){

        if(target == 0) re.add(new ArrayList<Integer>(temp));
        if(target>0){
            for(int i= start;i<nums.length;i++){
                temp.add(nums[i]);
                /**
                 * 下一步的起点仍为i，是因为题里说明，可以重复，如果不可重复，就从i+1开始
                 */
                find(nums,i,target-nums[i],re,temp);
                temp.remove(temp.size()-1);

            }
        }
    }
}
