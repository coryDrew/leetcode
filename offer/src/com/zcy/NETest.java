package com.zcy;

public class NETest {
    //单向链表，要求把单向链表两两反转，返回头结点
    //a b c d e
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }
    public static ListNode resort(ListNode head){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode tailPre = dummy;
        ListNode tail = head;
        while(tailPre != null && tail != null){
            ListNode cur = tail;
            ListNode pre = null;
            ListNode next = null;
            for(int i = 0;i < 2;i++){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            tailPre.next = pre;
            tail.next  = cur;
            tailPre = tail;
            tail = cur;
        }
        return dummy.next;
    }
}
