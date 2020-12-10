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

//maxProfitWithKChanceDFS
//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
//使用带有优化的深度优先搜索完成k次交易
//tested correct on Leetcode

//maxProfitDP
//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
//使用带有优化的动态规划完成k次交易
//tested correct on Leetcode

import java.util.HashMap;
import java.util.Map;

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
//    作者：wang_ni_ma
//    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/si-chong-jie-fa-tu-jie-188mai-mai-gu-piao-de-zui-j/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int maxProfitWithKChanceDFS(int k, int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        //当k非常大时转为无限次交易
        if(k>=n/2) {
            int dp0=0,dp1=-prices[0];
            for(int i=1;i<n;++i) {
                int tmp = dp0;
                dp0 = Math.max(dp0,dp1+prices[i]);
                dp1 = Math.max(dp1,dp0-prices[i]);
            }
            return Math.max(dp0,dp1);
        }
        Map<Key,Integer> cache = new HashMap<Key,Integer>();
        return dfs(cache,0,0,0,k,prices);
    }

    //带记忆化的 计算k次交易，代码和递归版的一样只是前后加了缓存
    private int dfs(Map<Key,Integer> cache, int index, int status, int count, int k, int[] prices) {
        Key key = new Key(index,status,count);
        if(cache.containsKey(key)) {
            return cache.get(key);
        }
        if(index==prices.length || count==k) {
            return 0;
        }
        int a=0,b=0,c=0;
        a = dfs(cache,index+1,status,count,k,prices);
        if(status==1) {
            b = dfs(cache,index+1,0,count+1,k,prices)+prices[index];
        } else {
            c = dfs(cache,index+1,1,count,k,prices)-prices[index];
        }
        cache.put(key,Math.max(Math.max(a,b),c));
        return cache.get(key);
    }
    //Key对象封装了index、status、交易次数count，作为map的key
    private class Key {
        private final int index;
        private final int status;
        private final int count;
        Key(int index,int status,int count) {
            this.index = index;
            this.status = status;
            this.count = count;
        }
        //这里需要实现自定义的equals和hashCode函数
        public int hashCode() {
            return this.index + this.status + this.count;
        }
        public boolean equals(Object obj) {
            Key other = (Key)obj;
            if(index==other.index && status==other.status && count==other.count) {
                return true;
            }
            return false;
        }
    }

    public int maxProfitDP(int k, int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        //当k非常大时转为无限次交易
        if(k>=n/2) {
            int dp0=0,dp1=-prices[0];
            for(int i=1;i<n;++i) {
                int tmp = dp0;
                dp0 = Math.max(dp0,dp1+prices[i]);
                dp1 = Math.max(dp1,dp0-prices[i]);
            }
            return Math.max(dp0,dp1);
        }
        //定义二维数组，交易了多少次、当前的买卖状态
        int[][] dp = new int[k+1][2];
        int res = 0;
        for(int i=0;i<=k;++i) {
            dp[i][0] = 0;
            dp[i][1] = -prices[0];
        }
        for(int i=1;i<n;++i) {
            for(int j=k;j>0;--j) {
                //处理第k次买入
                dp[j-1][1] = Math.max(dp[j-1][1], dp[j-1][0]-prices[i]);
                //处理第k次卖出
                dp[j][0] = Math.max(dp[j][0], dp[j-1][1]+prices[i]);

            }
        }
        return dp[k][0];
    }
}
