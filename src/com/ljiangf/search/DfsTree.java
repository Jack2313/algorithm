package com.ljiangf.search;
import com.ljiangf.General.GeneralMethods;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

//maxDepth
//https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
//求二叉树的最大深度
//tested correct on Leetcode

//isSymmetric
//https://leetcode-cn.com/problems/symmetric-tree/
//求当前二叉树是否对称
//tested correct on Leetcode

//isSameTree
//https://leetcode-cn.com/problems/same-tree/
//判断两个二叉树是否相同
//tested correct on Leetcode

//buildTree
//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//根据一棵树的前序遍历与中序遍历构造二叉树。
//tested correct on Leetcode

//buildTreeIteration
//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//通过迭代的思路，根据一棵树的前序遍历与中序遍历构造二叉树。
public class DfsTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private boolean isSymmetricTree(TreeNode left, TreeNode right){
        if(right == null){
            if(left == null)return true;
            return false;
        }else if(left == null){
            return false;
        }else{
            if(left.val == right.val){
                TreeNode lleft = left.left;
                TreeNode rleft = right.left;
                TreeNode lright = left.right;
                TreeNode rright = right.right;
                return isSymmetricTree(lleft, rright) && isSymmetricTree(rleft, lright);
            }else{
                return false;
            }
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isSymmetricTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null){
            if(q == null)return true;
            return false;
        }else if(q == null){
            return false;
        }else{
            if(p.val == q.val){
                TreeNode lleft = p.left;
                TreeNode rleft = q.left;
                TreeNode lright = p.right;
                TreeNode rright = q.right;
                return isSameTree(lleft, rleft) && isSameTree(rright, lright);
            }else{
                return false;
            }
        }
    }

    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int left, int right, int proot) {
        if(left>right)return null;
        if(left==right)return new TreeNode(preorder[proot]);
        TreeNode root = new TreeNode(preorder[proot]);
        int pRootInorder = GeneralMethods.searchArray(inorder, 0, preorder[proot]);
        int leftSize = pRootInorder - left;
        if(pRootInorder==-1)return null;
        TreeNode leftNode = buildTree(preorder, inorder, left, pRootInorder-1, proot+1);
        TreeNode rightNode = buildTree(preorder, inorder, pRootInorder+1, right, proot+leftSize+1);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0);
    }

    public TreeNode buildTreeIteration(int[] preorder, int[] inorder) {
        if(preorder.length==0 || preorder.length!=inorder.length)return null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                //相等的时候相当于到达了左侧子树的底部
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    public boolean hasPathSum(TreeNode root, int sum) {

    }
}
