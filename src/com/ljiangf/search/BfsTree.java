package com.ljiangf.Search;

import java.util.*;

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
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            // 每次都取出一层的所有数据
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            // 每次都往队头塞
            result.addFirst(oneLevel);
        }
        return result;
    }

    public int minDepth(TreeNode root) {
        int ans = 0;
        if (root == null)return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ans++;
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                    if (node.right != null){
                        queue.add(node.right);
                    }
                }else{
                    if (node.right != null){
                        queue.add(node.right);
                    }else{
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}
