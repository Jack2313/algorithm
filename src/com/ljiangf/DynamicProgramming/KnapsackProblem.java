package com.ljiangf.DynamicProgramming;

//canPartition
//https://leetcode-cn.com/problems/partition-equal-subset-sum/
//能否将数组均等切分
//tested correct on Leetcode

//findMaxForm
//https://leetcode-cn.com/problems/ones-and-zeroes/
//双重限制的0-1背包问题
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
}
