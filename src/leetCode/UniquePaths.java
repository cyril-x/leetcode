package leetCode;

/**
 * Created by coco-xsj on 2017/9/10.
 */
public class UniquePaths {
    //一个网格m*n求从左上到右下角的路径数量
    //1.用递归，时间超了。
    public int uniquePaths(int m, int n) {
        if(m==1&&n==1){
            return 1;
        }
        int i=0,j=0;
        if(m>1)i=uniquePaths(m-1,n);
        if(n>1)j=uniquePaths(m,n-1);

        return i+j;
    }
    public int uniquePathsII(int m, int n) {

        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0) dp[i][j]=1;
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
