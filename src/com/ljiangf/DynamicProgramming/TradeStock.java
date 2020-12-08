package com.ljiangf.DynamicProgramming;

//maxProfit
//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
//给一个价格序列，只买卖一次，找最好的方案。
//tested correct on Leetcode
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

    }
}
