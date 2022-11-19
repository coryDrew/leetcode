package com.zcy.offertwo.important;

import java.util.Deque;
import java.util.LinkedList;

public class Offer036 {
    //逆波兰，简单
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String s:tokens){
            if(isNumber(s)){
                stack.push(Integer.valueOf(s));
            }else{
                switch(s){
                    case "+":
                        stack.push(stack.pop()+stack.pop());
                        break;
                    case "-":
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(b - a);
                        break;

                    case "*":
                        stack.push(stack.pop()*stack.pop());
                        break;

                    case "/":
                        int c = stack.pop();
                        int d = stack.pop();
                        stack.push(d / c);
                        break;
                    default:break;
                }

            }
        }
        return stack.pop();
    }
    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
