package com.ljiangf.DivideAndConquer;
//tested correct on Leetcode
//https://leetcode-cn.com/problems/merge-k-sorted-lists/
public class MergeKLists {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }else{
            l2.next = merge2Lists(l1, l2.next);
            return l2;
        }
    }

    private ListNode divideAndMergeKLists(ListNode[] lists, int left, int right){
        if(left==right) return lists[left];
        int mid = (left+right)/2;
        ListNode l1 = divideAndMergeKLists(lists, left, mid);
        ListNode l2 = divideAndMergeKLists(lists, mid+1, right);
        return merge2Lists(l1,l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result;
        if(lists.length==0)return null;
        result = divideAndMergeKLists(lists, 0, lists.length-1);
        return result;
    }
}
