package com.zcy.interview.hash;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    //Node类和map（根据node的key找node）
    //移除hash不要忘记
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    int size;
    int capacity;
    Node head;
    Node tail;
    Map<Integer,Node> map;//根据key找节点
    public LRU(int capacity) {
        map = new HashMap<>();
        size = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){//移到队头
            Node cur = map.get(key);
            Node curPre = cur.prev;
            Node curNext = cur.next;
            curPre.next = curNext;
            curNext.prev = curPre;
            Node headNext = head.next;
            head.next = cur;
            cur.prev = head;
            cur.next = headNext;
            headNext.prev = cur;
            return cur.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            Node cur = new Node(key,value);
            map.put(key,cur);
            Node next = head.next;
            head.next = cur;
            cur.prev = head;
            cur.next = next;
            next.prev = cur;
            size++;
            if(size > capacity){//大于容量，移除最前面的，要记得同时移除hash表
                Node rem = tail.prev;
                Node tailPre = tail.prev.prev;
                tailPre.next = tail;
                tail.prev = tailPre;
                size--;
                map.remove(rem.key);
            }
        }else{//修改值，还要提到最前面
            Node cur = map.get(key);
            cur.value = value;
            Node curPre = cur.prev;
            Node curNext = cur.next;
            curPre.next = curNext;
            curNext.prev = curPre;
            Node headNext = head.next;
            head.next = cur;
            cur.prev = head;
            cur.next = headNext;
            headNext.prev = cur;
        }
    }
}
