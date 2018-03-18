package leetCode;

/**
 * Created by d-xsj on 21/12/2017.
 */
public class Keyskeyboard650 {
    //至今没想明白的做法

    int minSteps(int n) {
        if (n == 1) return 0;
        for (int i = 2; i < n; i++)
            if (n % i == 0) return i + minSteps(n / i);
        return n;
    }
    /**
     *  比我做法好一点点的做法，没想明白。
     */
    public int minStepslittle(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }

            }
        }
        return dp[n];
    }
//第一次的做法，及优化之后的做法

    /**
     *
     * 用dp[i]来表示 i个所需要的最小个数
     * tips:这道题有个数学点，对于i%j==0，j越大最终需要的步数越少，没想明白。。
     *
     */
    public int minStepss(int n) {
        int[] dp =new int[n+1];
        if(n == 0){
            return 0;
        }
        dp[1]=0;
        for(int m=2;m<=n;m++){
            dp[m] = m;
        }
        /** for(int num = 2;num<=n;num++){
         for(int i = 1;i<=num/2;i++){
         for(int j = 1;j<=i;j++){
         if(i*j==num)dp[num] = Math.min(dp[num],Math.min(i+dp[j],j+dp[i]));
         }

         }
         }*/
        for(int num =2;num<=n;num++){
            for(int i=num-1;i>1;i--){
                if(num%i==0) dp[num]=Math.min(dp[num],num/i+dp[i]);
            }}
        return dp[n];


    }
}
