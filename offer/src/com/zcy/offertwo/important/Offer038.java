package com.zcy.offertwo.important;

import java.util.Deque;
import java.util.LinkedList;

public class Offer038 {
    //自写单调栈
    //其实就是栈，写着写着就成了“单调栈”，很自然的想法
    public int[] dailyTemperatures(int[] temperatures) {
        //栈里面存下标！
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int[] res = new int[temperatures.length];
        for(int i = 1;i < temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.peek();
                res[index] =  i - stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            res[stack.pop()] = 0;
        }
        return res;
    }
}
