package leetCode;

import java.util.Arrays;

/**
 * Created by coco-xsj on 2017/9/6.
 */
public class maxProfit {
    public int maxProfit(int[] prices) {
      /*
        超时注意尽量不用双重循环

        if(prices == null||prices.length == 0){
            return 0;
        }
        int curmin=0,curmax=0;
        int len = prices.length;
        int dp[] = new int[len];
        int temp;
        for(int i=len -1;i>=0;i--){
            for(int j= i-1;j>=0;j--){
                temp = prices[i]-prices[j];
                dp[i]=Math.max(dp[i],temp);
            }

        }
        Arrays.sort(dp);
        return dp[len-1];*/
      /*
        * 当最小值和最大值都不固定时，要固定一边，同时不停刷新最终结果
        * */
        if(prices == null||prices.length <=1){
            return 0;
        }
        if(prices.length==1){
            return prices[0];
        }
        int max =0;
        int len = prices.length;
        int cur=prices[len-1];
        for(int i = len -2;i>=0;i--){
            if(prices[i]<cur){
                max = max>cur-prices[i]?max:cur-prices[i];
            }else{
                cur = prices[i];
            }
        }
        return max;
        //另一种从前往后遍历
        /* if(prices == null||prices.length <=1){
            return 0;
        }
      int min = Integer.MAX_VALUE;

        int profit = 0;

        for (int i : prices) {

            min = i < min ? i : min;

            profit = (i - min) > profit ? i - min : profit;

        }

        return profit;
        * */


    }
}
