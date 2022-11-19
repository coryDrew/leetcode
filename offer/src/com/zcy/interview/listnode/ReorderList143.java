package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class ReorderList143 {
    //自写
    public void reorderList(ListNode head) {
        //找到中间节点然后对后半部分反转
        //然后归并
        if(head.next == null)return;
        ListNode fast = head.next;
        ListNode slow = head;
        //找到要反转的前一个节点
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
        ListNode dummyHead = new ListNode();
        ListNode curH = dummyHead;
        boolean flag = true;
        ListNode curA = head;
        ListNode curB = headB;
        while(curA != null && curB != null){
            if(flag){
                curH.next = curA;
                curA = curA.next;
            }else{
                curH.next = curB;
                curB = curB.next;
            }
            curH = curH.next;
            flag = !flag;
        }
        if(curA != null)curH.next = curA;
        if(curB != null)curH.next = curB;

    }
}
