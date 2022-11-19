package com.zcy.interview.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2)return intervals;
        Arrays.sort(intervals,(o1, o2) -> (o1[0] - o2[0]));
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i < intervals.length;i++){
            if(list.size() == 0){
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }else{
                if(intervals[i][1] < list.get(list.size() - 1)[1]){
                    continue;
                }
                if(intervals[i][0] > list.get(list.size() - 1)[1]){
                    list.add(new int[]{intervals[i][0],intervals[i][1]});}
                if(intervals[i][0] <= list.get(list.size() - 1)[1]&&
                        intervals[i][1] > list.get(list.size() - 1)[1]){
                    list.get(list.size() - 1)[1] = intervals[i][1];
                }

            }


        }
        return list.toArray(new int[list.size()][]);
    }
}
