package com.ljiangf.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

//numTrees
//https://leetcode-cn.com/problems/unique-binary-search-trees/
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//tested correct on Leetcode

//generateTrees
//https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
//返回所有由 1 ... n 为节点所组成的 二叉搜索树
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

    private List<TreeNode> generateBranch(int left, int right) {
        List<TreeNode> result = new ArrayList<>();

        if(left>right){
            result.add(null);
            return result;
        }

        for(int i=left;i<=right;i++){
            List<TreeNode> leftTrees = generateBranch(left, i-1);
            List<TreeNode> rightTrees = generateBranch(i+1, right);
            for(TreeNode l:leftTrees){
                for(TreeNode r:rightTrees){
                    TreeNode head = new TreeNode(i);
                    head.left = l;
                    head.right = r;
                    result.add(head);
                }
            }
        }
        return result;
    }

    public List<TreeNode> generateTrees(int n) {
        return generateBranch(1,n);
    }
}
