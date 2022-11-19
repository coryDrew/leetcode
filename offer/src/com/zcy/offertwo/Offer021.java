package com.zcy.offertwo;

import com.zcy.usualClass.ListNode;

public class Offer021 {
    //自写
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        for(int i = 0;i < n;i++){
            fast = fast.next;
        }
        while(fast != null&&fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
