package com.zcy.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue232 {

    Deque<Integer> stackA;
    Deque<Integer> stackB;
    public MyQueue232() {
        stackA  = new LinkedList<>();
        stackB  = new LinkedList<>();
    }
    public void push(int x) {
        stackA.push(x);
    }

    public int pop() {
        if(stackB.isEmpty()){//B栈为空的时候从A栈倒东西，一次性倒完！
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.pop();
    }

    public int peek() {
        if(stackB.isEmpty()){
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        return stackB.peek();
    }

    public boolean empty() {
        return stackA.isEmpty()&&stackB.isEmpty();
    }
}
