package com.zcy.ListNode;

import java.util.ArrayDeque;

public class Flatten430 {
    public Node flatten(Node head) {
        //写递归写乱了！爱
        //评论区用栈的方法更好
        //如下
        Node node = head;
        Node prev = null;//用prev跟踪node的前一个位置，当node为null时prev正好指向不为null的最后一个节点，可以做拼接工作
        Deque<Node> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            if (node == null) {
                node = stack.pop();//将最后一个节点和原来的next建立前后关系，太妙了
                node.prev = prev;
                prev.next = node;
            }
            if (node.child != null) {
                if (node.next != null) stack.push(node.next);//把原来的next节点入栈
                node.child.prev = node;//和child建立前后关系
                node.next = node.child;
                node.child = null;
            }
            prev = node;
            node = node.next;
        }
        return head;
    }
}
