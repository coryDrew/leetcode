package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class DeleteDuplicates83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            if(pre != null && pre.val == cur.val){
                pre.next = pre.next.next;
                cur = pre.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
