package com.zcy.ListNode;

public class FrontMiddleBackQueue1670 {
    class DLinkedNode{
        int val;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int val){
            this.val = val;
        }
    }
    DLinkedNode head;
    DLinkedNode tail;
    int size;
    public FrontMiddleBackQueue() {
        size = 0;
        head = new DLinkedNode(-1);
        tail = new DLinkedNode(-1);
        head.next = tail;
        tail.pre = head;

    }

    public void pushFront(int val) {
        size++;
        DLinkedNode node = new DLinkedNode(val);
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public void pushMiddle(int val) {
        size++;
        DLinkedNode fast = head.next;
        DLinkedNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //在slow的后面加
        DLinkedNode node = new DLinkedNode(val);
        node.pre = slow;
        node.next = slow.next;
        slow.next = node;
        node.next.pre = node;
    }

    public void pushBack(int val) {
        size++;
        DLinkedNode node = new DLinkedNode(val);
        node.pre = tail.pre;
        tail.pre.next = node;
        node.next = tail;
        tail.pre = node;
    }

    public int popFront() {
        if(head.next.val == -1){
            return -1;
        }
        size--;
        int res = head.next.val;
        head.next = head.next.next;
        head.next.pre = head;
        return res;
    }

    public int popMiddle() {
        //分奇偶
        DLinkedNode fast = head.next;
        DLinkedNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        int res;
        if(size%2 != 0){
            if(slow.next.val == -1){
                return -1;
            }
            //移掉slow后面的
            res = slow.next.val;
            slow.next = slow.next.next;
            slow.next.pre = slow;
        }else{
            if(slow.val == -1){
                return -1;
            }
            //移掉当前slow
            res = slow.val;
            slow.pre.next = slow.next;
            slow.next.pre = slow.pre;
        }


        size--;
        return res;
    }

    public int popBack() {
        if(tail.pre.val == -1){
            return -1;
        }
        size--;

        int res = tail.pre.val;
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
        return res;
    }
}
