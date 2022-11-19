package com.zcy.sort;

import java.util.Arrays;

public class NumRescueBoats881{
    //最小匹配不了最大，则最大只能一个人坐船！
    public int numRescueBoats(int[] people, int limit) {
        //排序
        //最小配最大！
        Arrays.sort(people);
        int len = people.length;
        int l = 0,r = len - 1;
        int res = 0;
        while(l <= r){
            if(l == r){
                res++;
                break;
            }
            if(people[l] + people[r]<=limit){
                res++;
                l++;
                r--;
            }else{
                res++;
                r--;
            }
        }
        return res;

    }
}
