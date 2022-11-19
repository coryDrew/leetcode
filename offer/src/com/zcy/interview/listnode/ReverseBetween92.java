package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class ReverseBetween92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //找到反转的前一个节点以及反转后的最后一个节点 即例子中的1和2  即尾和尾的前一个，类似reverseKGroup
        //先来一个dummyHead，避免从第一个开始反转
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        for(int i = 0;i < left - 1;i++){
            cur1 = cur1.next;
        }
        ListNode first = cur1;
        ListNode last = first.next;
        ListNode cur = first.next;
        ListNode pre = null;
        ListNode next = null;
        for(int i = 0;i < right - left + 1;i++){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        first.next = pre;
        last.next = cur;
        return dummyHead.next;
    }
}
