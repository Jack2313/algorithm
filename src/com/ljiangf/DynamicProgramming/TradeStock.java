package com.ljiangf.DynamicProgramming;

//maxProfit
//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
//给一个价格序列，只买卖一次，找最好的方案。
//tested correct on Leetcode

//maxProfitWithCoolDown
//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
//可交易多次，带一天冻结期。
//tested correct on Leetcode

//maxProfitWithFee
//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
//你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。返回获得利润的最大值。
//tested correct on Leetcode

//maxProfitWithKChance
//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
//只有k次交易机会
public class TradeStock {
    public int maxProfit(int[] prices) {
        if(prices.length==0)return 0;
        int min = prices[0];
        int max = 0;
        for(int x: prices){
            max = Math.max(max, x-min);
            min = Math.min(x, min);
        }
        return max;
    }

    public int maxProfitWithCoolDown(int[] prices) {
        if(prices.length==0)return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -1*prices[0];
        buy[1] = Math.max(buy[0], - prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        for(int i=2;i<prices.length;i++){
            buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        }
        return sell[prices.length-1];
    }

    public int maxProfitWithFee(int[] prices, int fee) {
        int sell = 0;
        int hold = -1*prices[0];
        for(int i=1;i<prices.length;++i){
            hold = Math.max(hold, sell-prices[i]);
            sell = Math.max(sell, hold+prices[i]-fee);
        }
        return sell;
    }

    public int maxProfitWithKChance(int k, int[] prices) {

    }
}
