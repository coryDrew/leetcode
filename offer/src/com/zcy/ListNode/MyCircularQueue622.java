package com.zcy.ListNode;

import com.zcy.usualClass.ListNode;

public class MyCircularQueue622 {
    //没看出来哪循环了
    //普通队列会有假溢出现象，循环队列解决了！！
    private ListNode head;
    private ListNode tail;
    private int capacity;
    private int size;

    public MyCircularQueue622(int k) {
        capacity = k;
        size = 0;
    }

    public boolean enQueue(int value) {
        //添加到队尾
        if (isFull()) {
            return false;
        }
        ListNode node = new ListNode(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        //移的是队头
        if (isEmpty()) {
            return false;
        }
        ListNode node = head;
        head = head.next;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
