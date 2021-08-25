package com.ljiangf.DivideAndConquer;

// 排序链表
// https://leetcode-cn.com/problems/sort-list/
// 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeSortList {

    public ListNode sortList(ListNode head) {
        return head;

    }

    private MergeKLists.ListNode merge2Lists(MergeKLists.ListNode l1, MergeKLists.ListNode l2){
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
}
