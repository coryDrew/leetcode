package com.zcy.array;

import java.util.ArrayList;
import java.util.List;

public class Insert57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //二维数组的各种表示，学学答案，灵活转换
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> res = new ArrayList<>();
        for(int[] interval:intervals){
            if(interval[0]>right){
                if(!placed){
                    res.add(new int[]{left,right});
                    placed = true;
                }
                res.add(interval);
            }else if(interval[1] < left){
                res.add(interval);
            }else{
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if (!placed) {
            res.add(new int[]{left, right});
        }
        int[][] ans = new int[res.size()][2];
        for(int i = 0;i < ans.length;i++){
            ans[i][0] = res.get(i)[0];//这里可以直接ans[i] = res.get(i),一行搞定
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }
}
