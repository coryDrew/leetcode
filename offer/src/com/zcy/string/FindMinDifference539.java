package com.zcy.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMinDifference539 {
    //简单模拟
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        System.out.println(findMinDifference(list));
    }
    public static int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int len = timePoints.size();
        for(int i = 0;i < len;i++){
            list.add(toMunites(timePoints.get(i)));
        }
        Collections.sort(list);
        int res = list.get(0)+24*60 - list.get(len - 1);//特判，最小的和最大的有可能跨了一天
        for(int i = len - 1;i>0;i--){
            if(res>list.get(i) - list.get(i - 1)){
                res=list.get(i) - list.get(i - 1);
            }
        }
        return res;
    }
    public static int toMunites(String s){
        int hour = Integer.valueOf(s.substring(0,s.indexOf(':')));
        int mi = Integer.valueOf(s.substring(s.indexOf(':')+1,s.length()));
        return hour*60+mi;
    }
}
