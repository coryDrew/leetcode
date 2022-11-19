package com.zcy.offertwo.important;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU031 {
    //正确做法：手写一个双向链表，和哈希表一起用
    //双向链表中每个节点包含键和值，通过链表表示前后关系
    //哈希表的键存储键值对的键（有唯一性），值存储其对应的双向链表中的节点，这样就可以通过键以o（1）的时间定位到该节点，对该节点进行移位操作！！！
    //四个方法
    class LRUCache {
        class DLinkedNode{
            int key;
            int value;
            DLinkedNode next;
            DLinkedNode pre;
            public DLinkedNode(){}
            public DLinkedNode(int key,int value){
                this.key = key;
                this.value = value;
            }
        }
        int size;
        int capacity;
        DLinkedNode head;
        DLinkedNode tail;
        Map<Integer,DLinkedNode> map;
        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            map = new HashMap<>();
            head.next = tail;
            tail.next = head;
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }else{
                int res = map.get(key).value;
                moveToHead(map.get(key));
                return res;
            }
        }

        public void put(int key, int value) {
            if(!map.containsKey(key)){
                DLinkedNode node = new DLinkedNode(key,value);
                map.put(key,node);
                addToHead(node);
                size++;
                if(size>capacity){
                    DLinkedNode Tnode = removeTail();
                    map.remove(Tnode.key);
                    --size;
                }
            }else{
                DLinkedNode node = map.get(key);
                node.value = value;
                moveToHead(node);
            }
        }
        public void moveToHead(DLinkedNode node){
            removeNode(node);
            addToHead(node);
        }
        public void removeNode(DLinkedNode node){
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }
        public void addToHead(DLinkedNode node){
            DLinkedNode nextNode = head.next;
            head.next = node;
            node.pre = head;
            node.next = nextNode;
            nextNode.pre = node;
        }
        public DLinkedNode removeTail(){
            DLinkedNode node = tail.pre;
            removeNode(node);
            return node;
        }
    }



    //调apilinkedHashMap，面试直接挂
    //本质就是hashmap+双向链表
    //保证遍历时可以按照添加的顺序进行遍历
    //removeEldestEntry方法能设置何时删除老元素
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

}
