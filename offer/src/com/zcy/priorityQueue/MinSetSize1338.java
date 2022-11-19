package com.zcy.priorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinSetSize1338 {//简单题
    public int minSetSize(int[] arr) {
        //按出现次数排序，从大到小排，直到次数超过数组的一半
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->(map.get(o2) - map.get(o1)));
        for(int i = 0;i < arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);

        }
        for(int x:map.keySet()){
            pq.offer(x);
        }
        int res = 0;
        int cnt = 0;
        int len = arr.length;
        while(res< len/2){
            res += map.get(pq.poll());
            cnt++;
        }
        return cnt;
    }
}
