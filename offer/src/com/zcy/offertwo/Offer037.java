package com.zcy.offertwo;

import java.util.Deque;
import java.util.LinkedList;

public class Offer037 {
    //2ms,写的有点乱，但挺快
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0;i < asteroids.length;i++){
            if(asteroids[i] > 0){
                stack.push(asteroids[i]);
            }else{
                if(stack.isEmpty()){
                    stack.push(asteroids[i]);
                    continue;
                }
                while(!stack.isEmpty()&&stack.peek() >0 && stack.peek() < -1*asteroids[i]){
                    stack.pop();
                }
                if(!stack.isEmpty()&&stack.peek()>0){
                    if(stack.peek() + asteroids[i] == 0){
                        stack.pop();
                    }
                    continue;
                }else{
                    stack.push(asteroids[i]);
                }
            }
        }
        int[] res = new int[stack.size()];
        int index = stack.size() - 1;
        while(!stack.isEmpty()){

            res[index--] = stack.pop();
        }
        return res;
    }
}
