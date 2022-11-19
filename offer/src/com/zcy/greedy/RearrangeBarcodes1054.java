package com.zcy.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeBarcodes1054 {
    //和767一样
    public int[] rearrangeBarcodes(int[] barcodes) {
    //int count = new int[10000];
    //元素范围太大时，不如用hash
    Map<Integer,Integer> map = new HashMap<>();
    for(int i = 0;i < barcodes.length;i++){
        map.put(barcodes[i],map.getOrDefault(barcodes[i],0)+1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->map.get(o2) - map.get(o1));
    for(int k: map.keySet()){
        pq.offer(k);
    }
    int[] res = new int[barcodes.length];
    int index = 0;
    while(pq.size() > 1){
        int x = pq.poll();
        int y = pq.poll();
        res[index++] = x;
        res[index++] = y;
        map.put(x,map.get(x) - 1);
        map.put(y,map.get(y) - 1);
        if(map.get(x) > 0){
            pq.offer(x);
        }
        if(map.get(y) > 0){
            pq.offer(y);
        }

    }
    if(pq.size() > 0){//最后最多剩一个，且只有一个数量了
        res[index++] = pq.poll();
    }
    return res;
}
}
