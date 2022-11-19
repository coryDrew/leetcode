package com.zcy.interview.satckandqueue;

import java.util.Stack;

public class MinStack {
    //没写出来！！！！
    //辅助栈与正常栈保证相同个数，记录插入每个元素时栈中的最小值
    Stack<Integer> stack;
    Stack<Integer> min_Stack;
    public MinStack() {
        stack = new Stack<>();
        min_Stack = new Stack<>();
        min_Stack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(val);
            min_Stack.push(val);
        }else{
            stack.push(val);
            min_Stack.push(Math.min(min_Stack.peek(),val));
        }
    }

    public void pop() {//同时出栈，非常关键！！！！
        stack.pop();
        min_Stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_Stack.peek();
    }
}
