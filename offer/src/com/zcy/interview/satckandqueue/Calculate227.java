package com.zcy.interview.satckandqueue;

import java.util.Deque;
import java.util.LinkedList;

public class Calculate227 {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int len = s.length();
        int num = 0;
        char pre = '+';
        for(int i = 0;i < len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i) - '0';//不着急压栈
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1){
                if(pre == '+'){
                    stack.push(num);
                }
                if(pre == '-'){
                    stack.push((-1)*num);
                }
                if(pre == '*'){
                    stack.push(num*stack.pop());
                }
                if(pre == '/'){
                    stack.push(stack.pop()/num);
                }
                num = 0;
                pre = s.charAt(i);
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
