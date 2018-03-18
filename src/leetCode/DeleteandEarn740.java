package leetCode;

import java.util.Arrays;

/**
 * Created by d-xsj on 22/12/2017.
 *
 * Given an array nums of integers, you can perform operations on the array.

 In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

 You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 *
 * 又一次没找到递推关系，以及在如何弄到map的循环上废了很多时间
 * dp[i]带表不删除nums[i]的最大值，那么 dp[i]=Math.max(dp[i-1],dp[i-2]+count[i]*i)
 * count[nums[i]]为nums[i]的个数
 */
public class DeleteandEarn740 {
    public int deleteAndEarn(int[] nums) {
        // Map mm = new HashMap<Integer,Integer>();

        int len = nums.length;
        if(len==0){return 0;}
        Arrays.sort(nums);
        int sum = nums[0];

        /*for(int i =0;i<len-1;i++){
            if(nums[i+1]==nums[i]){
                sum +=nums[i+1];
            }else{
                mm.put(nums[i],sum);
                sum = nums[i+1];
            }
            if(i==len-2){
                last = nums[i+1];
                if(nums[i+1]==nums[i]){

                    mm.put(nums[i],sum);
                }
                else{
                    mm.put(nums[i+1],sum);
                }
            }
        }*/
        int last = nums[len-1];
        int[] count = new int[last+1];
        for(int i=0;i<len;i++){
            count[nums[i]]++;
        }
        int[] dp=new int[last+1];
        dp[1] = count[1]*1;
        for(int i=2;i<last+1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+count[i]*i);
        }

        return dp[last];

    }
}
