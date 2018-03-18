package leetCode;

/**
 * Created by d-xsj on 21/12/2017.
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

 Find the maximum coins you can collect by bursting the balloons wisely.

 Note:
 (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * 分治法，
 *  用dp[i][j]表示从i到j消除后的最大值
 *  i-1，i----k-----j,j+1
 *  因此dp[i][j]=Math.max(dp[i][j],dp[i][k-1]+n[i-1]*n[k]*n[j+1]+dp[k+1][j])
 *  l为i 和j的距离
 */
public class BurstBalloons312 {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] n = new int[len+2];
        int[][] dp = new int[len+2][len+2];
        n[0]=1;
        n[len+1]=1;
        for(int i=1;i<=len;i++){
            n[i] = nums[i-1];
        }

        for(int l=1;l<=len;l++){
            for(int i=1;i<=len-l+1;i++ ){
                int j= i+l-1;
                for(int k=i;k<=j;k++){
                    dp[i][j]=Math.max(dp[i][j],dp[i][k-1]+n[i-1]*n[k]*n[j+1]+dp[k+1][j]);
                }
            }
        }
        return dp[1][len];

    }
}
