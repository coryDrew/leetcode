package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int a = 0;
        ListNode head = new ListNode();
        ListNode cur = head;
        while(cur1!= null || cur2 != null){
            int sum = 0;
            if(cur1 == null){
                sum = cur2.val;


            }
            if(cur2 == null){
                sum = cur1.val;


            }
            if(cur1!= null && cur2 != null){
                sum = cur1.val + cur2.val;

            }
            sum+=a;
            int res = sum%10;
            a = sum/10;
            cur.next = new ListNode(res);
            cur = cur.next;
            if(cur1 != null)cur1 = cur1.next;
            if(cur2 != null)cur2 = cur2.next;
        }
        if(a != 0)cur.next = new ListNode(a);
        return head.next;
    }
}
