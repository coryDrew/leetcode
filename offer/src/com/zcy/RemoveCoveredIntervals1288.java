package com.zcy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveCoveredIntervals1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(o1, o2)->{
            if(o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else{
                return o1[1] - o2[1];
            }
        });
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i = 1;i <  intervals.length;i++){
            int l = intervals[i][0],r = intervals[i][1];
            if(intervals[i][1]>list.get(list.size() - 1)[1]){
                if(intervals[i][0] == list.get(list.size() - 1)[0]){//等于时特判
                    list.remove(list.size() - 1);
                }
                list.add(new int[]{l,r});
            }
        }
        return list.size();
    }
}
