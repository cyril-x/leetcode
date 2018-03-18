package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by coco-xsj on 2017/9/10.
 */
public class ContinuousSubSum {
    //求连续子串和为n的倍数
    //求余数和为n的区间，即为所求空间
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);

            } else {
                if (i - map.get(sum) >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
    //动态规划
    public boolean checkSubarraySumII(int[] nums, int k) {

        int len =nums.length;
        if(len==1||len==0){
            return false;
        }
        int dp=0;
        int count=0;
        if(k==0){
            for(int m=0;m<len-1;m++){
                if(nums[m]+nums[m+1]==0){
                    return true;
                }else{
                    return false;
                }
            }
        }
        for(int i=0;i<len;i++){
            dp+=nums[i];
            for(int j=i+1;j<len;j++){

                dp+=nums[j];

                if(dp%k==0&&j-i+1>=2){
                    return true;
                }
            }
            dp =0;
        }
        return false;

    }
}
