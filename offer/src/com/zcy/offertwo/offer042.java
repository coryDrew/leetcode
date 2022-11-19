package com.zcy.offertwo;

import java.util.LinkedList;

public class offer042 {
    Queue<Integer>queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {

        while(!queue.isEmpty()&&queue.peek() < t - 3000){
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}
