package com.ljiangf.DynamicProgramming;

//https://leetcode-cn.com/problems/maximum-product-subarray/
//乘积最大子数组
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
public class MaxSubProduct {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        int[] dp_min = new int[nums.length];
        int max_value = nums[0];
        for(int i=0;i<nums.length;i++){
            dp[i] = nums[i];
            dp_min[i] = nums[i];
        }

        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                dp_min[i] = Math.min(nums[i], nums[i] * dp[i-1]);
                dp[i] = nums[i] * dp_min[i-1];
            }else{
                dp_min[i] = nums[i] * dp_min[i-1];
                dp[i] = Math.max(dp[i]*dp[i-1], dp[i]);
            }
            max_value = Math.max(max_value, dp[i]);
        }
        return max_value;
    }
}
