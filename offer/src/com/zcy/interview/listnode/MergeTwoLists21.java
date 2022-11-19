package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class MergeTwoLists21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode head = new ListNode();
        ListNode cur = head;
        while(cur1!=null && cur2!=null){
            if(cur1.val < cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        if(cur1!=null){
            cur.next = cur1;
        }
        if(cur2!=null){
            cur.next = cur2;
        }
        return head.next;
    }
}
