package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class DetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while(true){
                    if(fast == slow){
                        return fast;
                    }
                    fast = fast.next;
                    slow = slow.next;

                }
            }
        }
        return null;
    }
}
