package leetCode;

/**
 * Created by d-xsj on 20/12/2017.
 *
 *We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

 However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
 *
 *博弈论，从每种情况的最小值里取最大值，作为最保险的方法，所以要对1-n作为第一步选择都进行一次遍历
 * 而本题，进一步优化应该从（1+n）/2——n进行选择
 */
public class GuessNumbertwo375 {
    int dp[][];
    /*
    通过循环的起点来区分左右的范围

     */
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        for(int j=2; j<=n; j++){
            for(int i=j-1; i>0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int localMax = k + Math.max(table[i][k-1], table[k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i+1==j?i:globalMin;
            }
        }
        return table[1][n];
    }
    /*
    通过剪枝减少循环次数
    因为起点一定是在二分的右边的，这样才能做到走第二步时代价最小
     */
    private int helper(int l, int h){
        if(dp[l][h] != 0) {
            return dp[l][h];
        }

        if(l >= h) {
            return 0;
        }
        int mid = l + (h-l) / 2, min = Integer.MAX_VALUE, i;

        for(i=mid;i<h;i++) {
            min = Math.min(min, i + Math.max(helper(i + 1, h) , helper(l,i-1)));
        }

        dp[l][h] = min;

        return min;
    }

    /*
    跟第二种思想类似，但更暴力一点
     */
    public int dp(int[][] nums , int from ,int to ){
        if(from>=to){
            return 0;
        }
        if(nums[from][to]!=0){
            return nums[from][to];
        }
        nums[from][to] = Integer.MAX_VALUE;

        for(int i=from;i<=to;i++){
            int left = dp(nums,from,i-1);
            int right = dp(nums,i+1,to);

            int temp = i+Math.max(left,right);

            nums[from][to]=Math.min(temp,nums[from][to]);
        }
        return nums[from][to];

    }
}
