package com.ljiangf.DynamicProgramming;

import java.util.List;

//minPathSum
//https://leetcode-cn.com/problems/minimum-path-sum/
//一个包含非负整数的 m x n 网格 grid ，每次只能向下或者向右移动一步。请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//tested correct on Leetcode

//minimumTotal
//https://leetcode-cn.com/problems/triangle/
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
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

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> preLayer = null;
        int length=0;
        for (List<Integer> x:triangle) {
            length = x.size();
            if(length == 1){
                preLayer = x;
                continue;
            }
            //System.out.println(preLayer.toString());
            x.set(0, x.get(0)+preLayer.get(0));
            x.set(length-1, x.get(length-1)+preLayer.get(length-2));
            for(int i=1;i<length-1;++i){
                x.set(i, x.get(i)+Math.min(preLayer.get(i-1),preLayer.get(i)));
            }
            preLayer = x;
        }
        int min = 0x7fffffff;
        for (int x: triangle.get(triangle.size()-1)) {
            min = Math.min(min, x);
        }
        return min;
    }
}
