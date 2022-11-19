package com.zcy.priorityQueue;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class StockPrice2034 {
    //自写，177ms
    //最好用pq
    TreeMap<Integer,Integer> map;
    TreeMap<Integer,Integer> time;//记录每个值出现了几次
    public StockPrice2034() {
        map = new TreeMap<>();
        time = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            int p = map.get(timestamp);
            time.put(p,time.get(p) - 1);
            if(time.get(p) == 0){
                time.remove(p);
            }
        }
        map.put(timestamp,price);
        time.put(price,time.getOrDefault(price,0)+1);

    }

    public int current() {
        return map.get(map.lastKey());
    }

    public int maximum() {
        return time.lastKey();
    }

    public int minimum() {
        return time.firstKey();

    }
    //*******************************************************************
    int maxTimestamp;
    HashMap<Integer, Integer> timePriceMap;
    PriorityQueue<int[]> pqMax;
    PriorityQueue<int[]> pqMin;

    public StockPrice() {
        maxTimestamp = 0;
        timePriceMap = new HashMap<Integer, Integer>();
        pqMax = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        pqMin = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        timePriceMap.put(timestamp, price);
        pqMax.offer(new int[]{price, timestamp});
        pqMin.offer(new int[]{price, timestamp});
    }

    public int current() {
        return timePriceMap.get(maxTimestamp);
    }

    public int maximum() {
        while (true) {
            int[] priceTime = pqMax.peek();
            int price = priceTime[0], timestamp = priceTime[1];
            if (timePriceMap.get(timestamp) == price) {
                return price;
            }
            pqMax.poll();
        }
    }

    public int minimum() {
        while (true) {
            int[] priceTime = pqMin.peek();
            int price = priceTime[0], timestamp = priceTime[1];
            if (timePriceMap.get(timestamp) == price) {
                return price;
            }
            pqMin.poll();
        }
    }


}
