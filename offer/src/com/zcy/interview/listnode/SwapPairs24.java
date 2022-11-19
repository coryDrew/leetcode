package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class SwapPairs24 {
    //差点给我搞乱了
    public ListNode swapPairs(ListNode head) {
        if(head == null)return null;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = pre.next;
        ListNode next = cur.next;
        while(cur!= null&& next != null){
            ListNode last = next.next;
            next.next = cur;
            pre.next = next;
            cur.next = last;
            pre = cur;
            cur = last;
            if(cur != null){
                next = cur.next;
            }

        }
        return dummyHead.next;
    }
}
