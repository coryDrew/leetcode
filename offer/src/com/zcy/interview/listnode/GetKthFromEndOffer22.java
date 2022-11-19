package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class GetKthFromEndOffer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0;i < k;i++){
            fast = fast.next;
        }
        while(fast!= null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
