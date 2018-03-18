package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by d-xsj on 22/12/2017.
 */
public class CombinationSumII40 {
    /**
     * 大神解法
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        permute(result,0,new ArrayList<>(),target,candidates,0);
        return result;
    }

    public void permute(List<List<Integer>> result, int sum, List<Integer> tempList, int target, int[] candidates, int start) {
        if(sum >= target) {
            if(sum == target)
                result.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(sum+candidates[i] <= target) {
                /**
                 * 这一步很神奇，假设数组为[10, 1, 2, 7, 6, 1, 5]，
                 * 排序之后为[1，1，2，5，6，7，10]
                 * 下面的这个判断允许1，1作为一个数组的前两位出现
                 * 但是不允许分别作为第一位出现，从而避免了重复结果的出现
                 */


                if(i > start && candidates[i] == candidates[i-1]) continue;
                tempList.add(candidates[i]);
                permute(result,sum+candidates[i],tempList,target,candidates,i+1);
                tempList.remove(tempList.size()-1);
            } else {
                break;
            }
        }
    }
    /**
     * 我的解法，用一个hashset来去重。。。结果的效率自然比不上大神解法
     */
    public List<List<Integer>> combinationSumII2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        List temp = new ArrayList<Integer>();
        find(candidates,re,temp,0,target);
        HashSet h = new HashSet(re);
        re.clear();
        re.addAll(h);
        return re;

    }

    public void find(int[] nums,List<List<Integer>> re,List<Integer> temp,int start,int target){
        if(target==0){re.add(new ArrayList(temp));}
        if(target>0){
            for(int i = start;i<nums.length; i++){
                temp.add(nums[i]);
                find(nums,re,temp,i+1,target-nums[i]);
                temp.remove(temp.size()-1);
            }
        }
    }
}
