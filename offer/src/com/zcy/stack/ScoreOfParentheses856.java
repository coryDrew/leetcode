package com.zcy.stack;

import java.util.Deque;
import java.util.LinkedList;

public class ScoreOfParentheses856 {
    //括号模拟题，基本都是栈，遇到左边基本都是进栈，遇到右边有不同的操作
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(0);
            }else{
                if(stack.peek() == 0){
                    stack.pop();
                    stack.push(1);
                }else{
                    int res = 0;
                    while(stack.peek() != 0){
                        res+=stack.pop();
                    }
                    stack.pop();
                    stack.push(res*2);
                }

            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum +=stack.pop();
        }
        return sum;
    }
}
