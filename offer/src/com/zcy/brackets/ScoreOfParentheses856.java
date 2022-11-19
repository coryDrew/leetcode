package com.zcy.brackets;

import java.util.Deque;
import java.util.LinkedList;

public class ScoreOfParentheses856 {
    //很难想
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
