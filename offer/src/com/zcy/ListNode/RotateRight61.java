package com.zcy.ListNode;


import com.zcy.usualClass.ListNode;

public class RotateRight61 {
    //自写100
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null||head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode last = null;
        int size = 0;
        while(cur!=null){//遍历确定有几个数
            size++;
            if(cur.next ==null){
                last = cur;
            }
            cur=cur.next;
        }
        if(k%size == 0){
            return head;
        }
        int n = k%size;//倒数第n个作为头
        //要找到倒数n+1个节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i = 0;i < n+1;i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        last.next = head;
        return newHead;
    }
}

