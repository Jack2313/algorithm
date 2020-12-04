package com.ljiangf.DynamicProgramming;

//uniquePaths
//https://leetcode-cn.com/problems/unique-paths/
//从 m x n 网格的左上角，每次只能向下或者向右移动一步。达到网格的右下角总共有多少条不同的路径
//tested correct on Leetcode

//uniquePathsWithObstacles
//https://leetcode-cn.com/problems/unique-paths-ii/
//图中有障碍物
//tested correct on Leetcode
public class PathNumber {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<n;++i)dp[0][i]=1;
        for(int[] x: dp)x[0]=1;

        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int ans = 0;
        if(obstacleGrid[0][0]==1)return ans;
        if(obstacleGrid[m-1][n-1]==1)return ans;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=1;i<n;++i){
            if(obstacleGrid[0][i]==0){
                dp[0][i] = dp[0][i-1];
            }
        }
        for(int i=1;i<m;++i){
            if(obstacleGrid[i][0]==0){
                dp[i][0] = dp[i-1][0];
            }
        }

        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                if(obstacleGrid[i-1][j]==0){
                    dp[i][j] = dp[i-1][j];
                }
                if(obstacleGrid[i][j-1]==0){
                    dp[i][j] += dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
