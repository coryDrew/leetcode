package com.zcy.offertwo;

import java.util.Deque;
import java.util.LinkedList;

public class offer041 {
    int size;
    Deque<Integer> dq;
    double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        dq = new LinkedList<>();
        this.sum = 0;
    }

    public double next(int val) {
        if(dq.size() == size){
            sum-= dq.pollFirst();
        }
        sum+=val;
        dq.addLast(val);
        return sum/dq.size();
    }
}
