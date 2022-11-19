package com.zcy.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Calculate227 {
    public int calculate(String s) {
        //单栈即可
        //记录上一个符号！，自己很难想
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char pre = '+';
        for(int i = 0;i < s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' '||i == s.length() - 1){
                if(pre == '+'){
                    stack.push(num);
                }
                if(pre == '-'){
                    stack.push(num*-1);
                }
                if(pre == '*'){
                    stack.push(stack.pop()*num);
                }
                if(pre == '/'){
                    stack.push(stack.pop()/num);
                }
                pre = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
