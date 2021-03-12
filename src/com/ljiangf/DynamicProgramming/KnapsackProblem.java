package com.ljiangf.DynamicProgramming;

import java.util.Arrays;

//canPartition
//https://leetcode-cn.com/problems/partition-equal-subset-sum/
//能否将数组均等切分
//tested correct on Leetcode

//findMaxForm
//https://leetcode-cn.com/problems/ones-and-zeroes/
//双重限制的0-1背包问题
//tested correct on Leetcode

//findTargetSumWays
//https://leetcode-cn.com/problems/target-sum/
//给定数字，分配加减号，得到目标值共有多少方法

//coinChange
//https://leetcode-cn.com/problems/coin-change/
//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
//如果没有任何一种硬币组合能组成总金额，返回-1。
//tested correct on Leetcode

//change
//https://leetcode-cn.com/problems/coin-change-2/
//给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
public class KnapsackProblem {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int x: nums
             ) {
            sum += x;
        }
        if(sum%2!=0){
            return false;
        }
        sum = sum/2;
        int[] dp = new int[sum];
        for(int i=0;i<nums.length;i++){
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            if(dp[sum]==sum) return true;
        }
        return false;
    }

    private int[] countZeros(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String s: strs){
            int[] count = countZeros(s);
            for(int i=m;i>count[0];--i){
                for(int j=n;j>count[1];--j){
                    dp[i][j] = Math.max(dp[i-count[0]][j-count[1]]+1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    public int findTargetSumWays(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;++i)dp[i] = 0x7fffffff;
        for(int c: coins){
            for (int j = c; j <= amount; ++j) {
                if(dp[j - c]==0x7fffffff)continue;
                dp[j] = Math.min(dp[j], dp[j - c] + 1);
            }
            //System.out.println(Arrays.toString(dp));
        }
        if(dp[amount]==0x7fffffff){
            return -1;
        }else{
            return dp[amount];
        }
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        return 1;
    }
}
