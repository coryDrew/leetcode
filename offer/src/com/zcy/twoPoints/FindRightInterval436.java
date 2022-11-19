package com.zcy.twoPoints;

import java.util.Arrays;

public class FindRightInterval436 {
    //不要暴力，记录下标，想到这一点了，但没想到怎么记录
    //双指针，还可以用二分做
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        int[][] endIntervals = new int[n][2];
        for(int i = 0;i < n;i++){
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
            endIntervals[i][0] = intervals[i][1];
            endIntervals[i][1] = i;
        }
        int[] res = new int[n];
        Arrays.sort(startIntervals,(o1, o2)->(o1[0] - o2[0]));
        Arrays.sort(endIntervals,(o1,o2)->(o1[0] - o2[0]));
        for(int i = 0,j = 0;i < n;i++){
            while(j < n && endIntervals[i][0] > startIntervals[j][0]){
                j++;
            }
            if(j<n){
                res[endIntervals[i][1]] = startIntervals[j][1];
            }else{
                res[endIntervals[i][1]] = -1;
            }
        }
        return res;
    }

    //二分
    public int[] findRightInterval1(int[][] intervals) {
        int n = intervals.length;
        int[][] startIntervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            startIntervals[i][0] = intervals[i][0];
            startIntervals[i][1] = i;
        }
        Arrays.sort(startIntervals, (o1, o2) -> o1[0] - o2[0]);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            int target = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (startIntervals[mid][0] >= intervals[i][1]) {
                    target = startIntervals[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }


}
