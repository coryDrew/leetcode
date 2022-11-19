package com.zcy.ListNode;

public class MyLinkedList707 {
    class Node{
        Node prev;
        Node next;
        int val;
        public Node(int val){
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int size;
    public MyLinkedList707() {
        head = new Node(-1);
        tail = new Node(-1);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if(size >= index){
            Node node = head;
            while(index-- > 0){
                node = node.next;
            }
            return node.next.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        Node pre = tail.prev;
        pre.next = node;
        node.prev = pre;
        node.next = tail;
        tail.prev = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        Node node = head;
        while(index-- > 0){
            node = node.next;
        }
        Node cur = new Node(val);
        Node next = node.next;
        node.next = cur;
        cur.prev = node;
        cur.next = next;
        next.prev = cur;
        size++;
    }

    public void deleteAtIndex(int index) {
        if(size > index){
            Node node = head;
            while(index-- > 0){
                node = node.next;
            }
            node.next =node.next.next;
            node.next.prev = node;
            size--;
        }

    }
}
