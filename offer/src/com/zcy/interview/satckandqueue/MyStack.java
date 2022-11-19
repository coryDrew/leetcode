package com.zcy.interview.satckandqueue;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {
    //没写出来
    Deque<Integer> queueA;
    Deque<Integer> queueB;
    public MyStack() {
        queueA = new LinkedList<>();
        queueB = new LinkedList<>();
    }
    //a栈保证push时为空 先把元素放到a，然后b的所有元素进入a，然后ab互换！
    public void push(int x) {
        queueA.offer(x);
        while(!queueB.isEmpty()){
            queueA.offer(queueB.poll());
        }
        Deque tmp;
        tmp = queueA;
        queueA = queueB;
        queueB = tmp;
    }

    public int pop() {
        return queueB.poll();
    }

    public int top() {
        return queueB.peek();
    }

    public boolean empty() {
        return queueB.isEmpty();
    }
}
