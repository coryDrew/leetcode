package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class SortList148 {
    public ListNode sortList(ListNode head) {
        return merge(head);
    }
    public ListNode merge(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode headB = slow.next;
        slow.next = null;
        head = merge(head);
        headB = merge(headB);
        return mergeTwoList(head,headB);

    }
    public ListNode mergeTwoList(ListNode node1,ListNode node2){
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while(node1!= null && node2!=null){
            if(node1.val < node2.val){
                cur.next = node1;
                node1 = node1.next;
            }else{
                cur.next = node2;
                node2 = node2.next;
            }
            cur = cur.next;
        }
        if(node1 != null) cur.next = node1;
        if(node2 != null) cur.next = node2;
        return dummyHead.next;
    }
}
