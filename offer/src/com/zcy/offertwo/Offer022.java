package com.zcy.offertwo;

import com.zcy.usualClass.ListNode;

public class Offer022 {
    //比管方解更清晰的做法
    //官方解那while嵌套，逆天
    public ListNode detectCycle(ListNode head) {
        if(head == null||head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null&&fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast != slow)return null;
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
