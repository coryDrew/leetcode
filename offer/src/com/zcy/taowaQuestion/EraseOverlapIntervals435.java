package com.zcy.taowaQuestion;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals435 {
    //超时   通过55/58
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(x, y)->(x[0] - y[0]));
        int[] dp = new int[intervals.length];
        int res = 0;
        for(int i = 0;i < intervals.length;i++){
            for(int j = 0;j < i;j++){
                if(intervals[j][1] <= intervals[i][0]){
                    dp[i] = Math.max(dp[j],dp[i]);
                }
            }
            dp[i]+=1;
            res = Math.max(dp[i],res);
        }
        return intervals.length - res;
    }

    //贪心
    public int eraseOverlapIntervals6666(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];//按end时间排序
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }


}
