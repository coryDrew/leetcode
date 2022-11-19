package com.zcy.interview.satckandqueue;

public class MyQueue {
    Stack<Integer> stackA;
    Stack<Integer> stackB;
    public MyQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        stackA.push(x);
    }

    public int pop() {
        if(!stackB.isEmpty()){
            return stackB.pop();
        }else{
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
            return stackB.pop();
        }
    }

    public int peek() {
        if(!stackB.isEmpty()){
            return stackB.peek();
        }else{
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
            return stackB.peek();
        }
    }

    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }
}
