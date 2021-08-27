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
        ListNode current;
        current = head;
        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for(int i=1; i<length; i=i<<1){
            current = dummyHead.next;
            ListNode prev = dummyHead;
            // i是每次合并的list长度
            while(current != null){
                int listLength = 1;
                ListNode head1 = current;
                while(listLength<i && current!=null){
                    current = current.next;
                    listLength++;
                }
                if(current == null){
                    break;
                }
                ListNode head2 = current.next;
                current.next = null;
                current = head2;

                listLength = 1;
                while(listLength<i && current!=null){
                    current = current.next;
                    listLength++;
                }
                ListNode head3 = null;
                if(current != null){
                    head3 = current.next;
                    current.next = null;
                }

                prev.next = merge2Lists(head1, head2);
                while(prev.next!=null){
                    prev = prev.next;
                }
                prev.next = head3;
                current = head3;
            }

        }
        return dummyHead.next;

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
}
