package com.zcy.priorityQueue;

import java.util.*;

public class TopKFluent {
    //大堆小堆都可以的
    //大堆 击败99
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2)->{
            int cnt1 = map.get(o1);
            int cnt2 = map.get(o2);
            if(cnt1 == cnt2){
                return o1.compareTo(o2);
            }else{
                return cnt2 - cnt1;
            }
        });
        for(String s:map.keySet()){//直接随便加，最后取前k个
            pq.add(s);
        }
        List<String> list = new ArrayList<>();
        for(int i = 0;i < k;i++){
            list.add(pq.poll());
        }
        return list;
    }
    //******************小堆********************
    //击败26，不如大堆
    public List<String> topKFrequent1(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((o1,o2)->{
            int cnt1 = map.get(o1);
            int cnt2 = map.get(o2);
            if(cnt1 == cnt2){
                return o2.compareTo(o1);
            }else{
                return cnt1 - cnt2;
            }
        });
        for(String s:map.keySet()){
            pq.add(s);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<String> list = new ArrayList<>();
        for(int i = 0;i < k;i++){
            list.add(pq.poll());
        }
        Collections.reverse(list);;
        return list;
    }
}
