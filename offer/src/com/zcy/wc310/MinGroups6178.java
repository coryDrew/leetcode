package com.zcy.wc310;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MinGroups6178 {
    错的
    public int minGroups(int[][] intervals) {
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        set.add(intervals[0][1]);
        int cnt = 1;
        for(int i = 1;i < intervals.length;i++){
            if(set.lower(intervals[i][0]) != null){
                set.remove(set.lower(intervals[i][0]));
                set.add(intervals[i][1]);
            }else{
                set.add(intervals[i][1]);
                cnt++;
            }

        }
        return cnt;
    }
    //正确
    //小根堆（优先队列） 想快速获取一些数中的最小值时，记得用
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });//排序，满足从小到大选择区间

        int m=intervals.length;

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];//当前请求加入分组的区间的起始值
            if (pq.isEmpty()) pq.offer(end);//空分组时
            else {
                if (start <= pq.peek()) {//不可加入已有的分组，直接以end新建分组
                    pq.add(end);
                } else {//可加入已有分组，加入其中并更新区间尾数end
                    pq.poll();
                    pq.offer(end);
                }
            }
        }
        return pq.size();
    }
}
