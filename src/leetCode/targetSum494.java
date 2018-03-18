package leetCode;

/**
 * Created by d-xsj on 20/12/2017.
 * http://blog.csdn.net/mine_song/article/details/70216562
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

 Find out how many ways to assign symbols to make sum of integers equal to target S.


 */
public class targetSum494 {
     static int count=0;
    public static int findTargetSumWays(int[] nums, int S) {


        dp(nums,0,S,0);
        return count;
    }
    public static void dp(int[] nums,int index,int S,int sum){
        if(index == nums.length&&sum == S){
            count++;
        }
        if(index <= nums.length-1&&sum<S){
            dp(nums,index+1,S,sum+nums[index]);
            dp(nums,index+1,S,sum-nums[index]);
        }

    }

    public static int findTargetSumWayss(int[] nums, int S) {
        if (nums.length == 0) return 0;
        int sum = 0;
        for (int num : nums) sum += num;


        /**
         * 举例说明: nums = {1,2,3,4,5}, target=3, 一种可行的方案是+1-2+3-4+5 = 3

         该方案中数组元素可以分为两组，一组是数字符号为正(P={1,3,5})，另一组数字符号为负(N={2,4})

         因此: sum(1,3,5) - sum(2,4) = target

         sum(1,3,5) - sum(2,4) + sum(1,3,5) + sum(2,4) = target + sum(1,3,5) + sum(2,4)

         2sum(1,3,5) = target + sum(1,3,5) + sum(2,4)

         2sum(P) = target + sum(nums)

         sum(P) = (target + sum(nums)) / 2

         由于target和sum(nums)是固定值，因此原始问题转化为求解nums中子集的和等于sum(P)的方案个数问题
         */
        if (sum < S||(sum + S) % 2 != 0) return 0;
        int k = (sum + S) / 2, n = nums.length;
        int[] dp = new int[k + 1];
        /**
         * 定义dp[10]数组, dp[10] = {1,0,0,0,0,0,0,0,0,0}

         dp[i]表示子集合元素之和等于当前目标值的方案个数, 当前目标值等于9减去当前元素值

         */

        dp[0] = 1;
        for (int num : nums) {
            for (int i = k; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[k];
    }



    public static void main(String[] args) {
        /*int[] m ={1,1,1,1,1};
        int S =5;
        System.out.println(findTargetSumWays(m,S));
        System.out.println(findTargetSumWayss(m,S));*/


        String a="a";
        char[] m = a.toCharArray();
        int sum=0;
        for(char ss:m){

            sum += ss;
        }
        System.out.println(sum);
    }

}
