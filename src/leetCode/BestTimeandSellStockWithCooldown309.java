package leetCode;

/**
 * Created by d-xsj on 22/12/2017.
 * 因为一天的动作会有买，卖，冷却三种动作
 * 状态会有持有和不持有两种，因此每种状态要分别递推
 * hold[i]表示持有股票时的最大利润，如果要持有，那他可能是当天买的 nhold[i-2]+price[i-1]
 *  因为要冷却一天，所以是两天前卖的价格，价格price[i-1]表示第i天的价格，因为最开始只能买，所以hold[1]=-price[0]
 * ，也可能是保持过来的 hold[i-1],
 * nhold[i]不持股，可能是刚卖，或者冷却
 * 刚卖就是当天价格加上一天前的利润 hold[i-1]+price[i-1],另一个就是nhold[i-1]
 */
public class BestTimeandSellStockWithCooldown309 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len==0){
            return 0;
        }
        int[] hold = new int[len+1];
        hold[1] = -prices[0];
        int[] nhold = new int[len+1];
        for(int i=2;i<=len;i++){
            hold[i] = Math.max(hold[i-1],nhold[i-2]-prices[i-1]);
            nhold[i] = Math.max(prices[i-1]+hold[i-1],nhold[i-1]);
        }
        return nhold[len];

    }
}
