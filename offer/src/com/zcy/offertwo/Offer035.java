package com.zcy.offertwo;

import java.util.Arrays;
import java.util.List;

public class Offer035 {
    public int findMinDifference(List<String> timePoints) {
        //还鸽巢原理呢
        if(timePoints.size() > 1440){
            return 0;
        }
        int len = timePoints.size();
        int[] minu = new int[len];
        int index = 0;
        for(String s:timePoints){
            minu[index++] = changeMinutes(s);
        }
        Arrays.sort(minu);
        int res = minu[0] + 24*60 - minu[len - 1];
        for(int i = len - 1;i>0;i--){
            res = Math.min(res,minu[i] - minu[i - 1]);
        }
        return res;
    }
    public int changeMinutes(String s){
        String[] minu = s.split(":");
        int h = Integer.valueOf(minu[0]);
        int m = Integer.valueOf(minu[1]);
        return h*60+m;
    }
}
