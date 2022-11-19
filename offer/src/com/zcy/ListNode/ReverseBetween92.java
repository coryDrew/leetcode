package com.zcy.ListNode;

import com.zcy.usualClass.ListNode;

public class ReverseBetween92 {
    //自写100
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //找到反转前面一个和反转后面一个
        if(head == null||head.next == null||left == right){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode before = dummyHead;
        ListNode behind = dummyHead;
        ListNode first = null;
        ListNode last = null;
        for(int i = 0;i < left - 1;i++){
            before = before.next;
        }
        for(int i = 0;i < right+1;i++){
            behind = behind.next;

        }
        ListNode cur = dummyHead;
        for(int i = 0;i < right;i++){
            cur = cur.next;
            if( i == left - 1){
                first = cur;
            }
            if(i == right - 1){
                last = cur;
            }
        }
        cur = first;
        ListNode next = null;
        ListNode pre = null;
        while(pre != last){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        before.next = last;
        first.next = behind;
        return dummyHead.next;

    }
}
