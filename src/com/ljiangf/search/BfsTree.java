package com.ljiangf.search;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//levelOrder
//https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。
//tested correct on Leetcode

//levelOrderBottom
//https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
//给定一个二叉树，返回其节点值自底向上的层序遍历。

public class BfsTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> line = new LinkedList<>();
        Deque<TreeNode> newline = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();

        if(root==null)return null;
        line.push(root);
        while(!line.isEmpty() || !newline.isEmpty()){
            List<Integer> thisLine = new LinkedList<>();
            while(!line.isEmpty()){
                thisLine.add(line.peek().val);
                if(line.peek().left != null){
                    newline.add(line.peek().left);
                }
                if(line.peek().right != null){
                    newline.add(line.peek().right);
                }
                line.pop();
            }
            line = newline;
            newline = new LinkedList<>();
            result.add(thisLine);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

    }
}
