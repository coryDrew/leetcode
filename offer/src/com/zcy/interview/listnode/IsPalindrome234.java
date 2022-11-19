package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class IsPalindrome234 {
    public boolean isPalindrome(ListNode head) {
        //找到中点并反转
        if(head.next == null) return true;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode headB = slow.next;
        slow.next = null;
        ListNode cur = headB;
        ListNode pre = null;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        headB = pre;
        while(head != null && headB != null){
            if(head.val != headB.val)return false;
            head = head.next;
            headB = headB.next;
        }
        return true;
    }
}
