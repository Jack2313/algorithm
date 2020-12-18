package com.ljiangf.search;

//sortedArrayToBST
//https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
//将升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//tested correct on Leetcode

//isValidBST
//https://leetcode-cn.com/problems/validate-binary-search-tree/
//验证当前树是否为二叉搜索树
public class DfsBSTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if(left>right){
            return null;
        }else if(left == right){
            return new TreeNode(nums[left]);
        }else{
            int mid = (left+right)/2;
            TreeNode ans = new TreeNode(nums[mid]);
            ans.left = sortedArrayToBST(nums, left, mid-1);
            ans.right = sortedArrayToBST(nums, mid+1, right);
            return ans;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private boolean isValidBSTree(TreeNode root, long max_value, long min_value){
        if(root==null)return true;
        if(root.val<max_value && root.val>min_value){
            return isValidBSTree(root.left, root.val, min_value) && isValidBSTree(root.right, max_value, root.val);
        }else{
            return false;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        return isValidBSTree(root.left, root.val, Long.MIN_VALUE) && isValidBSTree(root.right, Long.MAX_VALUE, root.val);
    }
}
