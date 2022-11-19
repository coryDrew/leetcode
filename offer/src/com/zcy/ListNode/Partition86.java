package com.zcy.ListNode;

import com.zcy.usualClass.ListNode;

public class Partition86 {
    //纯自写100，多创建了两个变量其实 cur和next不需要
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        ListNode dummyLess = new ListNode(0);
        ListNode dummyMore = new ListNode(0);
        ListNode less = dummyLess;
        ListNode more = dummyMore;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur != null){
            if(cur.val < x){
                less.next = cur;
                less = less.next;
            }else{
                more.next = cur;
                more = more.next;
            }
            cur = next;
            if(cur!= null){
                next = cur.next;
            }

        }
        more.next = null;
        less.next = dummyMore.next;
        return dummyLess.next;
    }
    //官方
    public ListNode partition1(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }


}
