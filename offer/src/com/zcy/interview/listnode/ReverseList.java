package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class ReverseList {
    //半分钟秒了
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
