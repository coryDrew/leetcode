package com.zcy.wc304;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClosestMeetingNode6134 {
    //自写，102ms
    public static void main(String[] args) {
        int[] edges = new int[]{5,3,1,0,2,4,5};

        System.out.println(closestMeetingNode(edges,3,2));
    }
    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        //描述图
        //57/72
        if(node1 == node2){
            return node1;
        }
        Map<Integer,Integer> map = new HashMap<>();//key点指向value点
        for(int i = 0;i < edges.length;i++){
            if(edges[i] != -1){
                map.put(i,edges[i]);
            }
        }
        //找两个点都能到达的点，并求出到这些点的距离
        boolean[] vis1 = new boolean[edges.length];
        boolean[] vis2 = new boolean[edges.length];
        Map<Integer,Integer> mapN1 = new HashMap<>();
        Map<Integer,Integer> mapN2 = new HashMap<>();
        mapN1.put(node1,0);
        mapN2.put(node2,0);
        int dis1 = 1;
        int dis2 = 1;
        while(map.containsKey(node1) &&vis1[node1] == false){
            vis1[node1] = true;
            node1 = map.get(node1);
            if(!mapN1.containsKey(node1)){
                mapN1.put(node1,dis1++);
            }

        }
        while(map.containsKey(node2) &&vis2[node2] == false){
            vis2[node2] = true;
            node2 = map.get(node2);
            if(!mapN2.containsKey(node2)){
                mapN2.put(node2,dis2++);
            }
        }
        int minMax = Integer.MAX_VALUE;
        int res = -1;
        for(Map.Entry<Integer,Integer> entry: mapN1.entrySet()){
            int key = entry.getKey();
            if(mapN2.containsKey(key) && Math.max(mapN2.get(key),entry.getValue()) < minMax){
                minMax = Math.max(mapN2.get(key),entry.getValue());
                res = key;
            }
        }
        return res;
    }

    //岭茶山爱抚
    //非常简练
    int[] edges;

    public int closestMeetingNode1(int[] edges, int node1, int node2) {
        this.edges = edges;
        int[] d1 = calcDis(node1), d2 = calcDis(node2);
        int ans = -1, n = edges.length;
        for (int i = 0, minDis = n; i < n; ++i) {
            int d = Math.max(d1[i], d2[i]);
            if (d < minDis) {
                minDis = d;
                ans = i;
            }
        }
        return ans;
    }

    int[] calcDis(int x) {
        int n = edges.length;
        int[] dis = new int[n];
        Arrays.fill(dis, n);
        for (int d = 0; x >= 0 && dis[x] == n; x = edges[x])//这个循环太妙了，又有终点判断又能避免环路
            dis[x] = d++;
        return dis;
    }



}
