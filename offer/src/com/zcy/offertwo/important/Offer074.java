package com.zcy.offertwo.important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer074 {
    //难点：怎么放到集合里去，放的时机，合并时是否要创建新数组？（不用！只要改右区间的值）
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1, o2)->(o1[0] - o2[0]));//按开始位置从小到大排序

        List<int[]> list = new ArrayList<>();
        for(int i = 0;i < intervals.length;i++){
            int l = intervals[i][0],r = intervals[i][1];
            if(list.size() == 0 || list.get(list.size() - 1)[1] < intervals[i][0]){
                list.add(new int[]{l,r});//不能修改原数组，要创建一个新数组
            }else{//要合并了
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1],r);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
