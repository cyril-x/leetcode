package leetCode;

/**
 * Created by d-xsj on 21/12/2017.
 */
public class LongestPalindromicSubseq516 {

    /**
     *
     * 求最长回文字串的长度
     * 从左向右需要固定j，从右向左需要固定i
     * 递推如代码
     */
    public int longestPalindromeSubseq(String s) {
        char[] sc = s.toCharArray();
        int len = sc.length;
        if(len==0){
            return 0;
        }



        int[][] dp = new int[len+1][len+1];
        for(int i=len;i>=1;i--){
            dp[i][i]=1;
            for(int j=i+1;j<=len;j++){
                if(sc[i-1]==sc[j-1]){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[1][len];

    }
}
