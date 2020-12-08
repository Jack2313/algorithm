package com.ljiangf.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

//numTrees
//https://leetcode-cn.com/problems/unique-binary-search-trees/
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
public class GenerateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int numTrees(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i<=n;++i){
            for(int j = 0;j<i;++j){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        return result;
    }
}
