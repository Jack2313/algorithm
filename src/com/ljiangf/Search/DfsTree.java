package com.ljiangf.Search;
import com.ljiangf.General.GeneralMethods;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
//tested correct on Leetcode

//hasPathSum
//https://leetcode-cn.com/problems/path-sum/
//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
//tested correct on Leetcode

//pathSum
//https://leetcode-cn.com/problems/path-sum-ii/
///给定一个二叉树和一个目标和，求该树中根节点到叶子节点的路径使所有节点值相加等于目标和。
//tested correct on Leetcode

//maxPathSum
//https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
//求最大的路径和
//tested correct on Leetcode

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
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        if(root==null)return result;
        if(root.val == sum && root.left == null && root.right == null){
            List<Integer> ans = new LinkedList<>();
            ans.add(root.val);
            result.add(ans);
            return result;
        }

        result.addAll(pathSum(root.left, sum - root.val));
        result.addAll(pathSum(root.right, sum - root.val));
        for(List<Integer> x: result){
            x.add(0, root.val);
        }
        return result;
    }

    private int maxSum = 0x80000000;
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

}
