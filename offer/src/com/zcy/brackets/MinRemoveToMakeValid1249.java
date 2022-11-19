package com.zcy.brackets;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class MinRemoveToMakeValid1249 {
    ReentrantLock
    /**
     思路挺简单的就是搭配括号，直接遍历s，遇到‘（’，将他的位置入栈； 遇到‘）’有两种可能，栈里有“（”，就出栈，没有‘（’即栈为空直接删除当前符号，此时s长度和下标需要--； 遍历完后如果栈不为空，说明存在‘（’没有匹配，故依次pop栈顶元素，逐个删除。
     */
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] remove = new boolean[s.length()];
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            if(s.charAt(i) == ')'){
                if(stack.isEmpty()){
                    remove[i] = true;
                }else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            remove[stack.pop()] = true;
        }
        for(int i = 0;i < remove.length;i++){
            if(remove[i] == false){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
