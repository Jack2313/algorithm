package com.ljiangf.GreedyAlgorithm;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
//tested correct on Leetcode

public class StockBusiness {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i=0;i<prices.length-1;++i){
            ans = ans+Math.max(0, prices[i]-prices[i+1]);
        }
        return ans;
    }
}
