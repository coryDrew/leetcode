package com.zcy.offertwo.important;

import java.util.PriorityQueue;

public class Offer059 {
    //priorityQueue，小根堆，保证队列里只有k个元素，堆顶就是第k大的
    //pq主要方法就是add/offer，remove/poll，peek
    //remove在队列为空时会抛异常，poll不会
    PriorityQueue<Integer> pq;
    int k;
    int []nums;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        pq = new PriorityQueue<>();
        for(int i = 0;i < nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){

                pq.remove();

            }
        }

    }

    public int add(int val) {
        pq.add(val);
        if(pq.size()>k){
            pq.remove();
        }
        return pq.peek();
    }
}
