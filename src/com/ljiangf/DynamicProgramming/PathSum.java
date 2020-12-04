package com.ljiangf.DynamicProgramming;

//minPathSum
//https://leetcode-cn.com/problems/minimum-path-sum/
//一个包含非负整数的 m x n 网格 grid ，每次只能向下或者向右移动一步。请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//tested correct on Leetcode
public class PathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i=1;i<n;++i){
            dp[0][i] = dp[0][i-1] + grid[0][i];

        }
        for(int i=1;i<m;++i){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                dp[i][j] = grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}
