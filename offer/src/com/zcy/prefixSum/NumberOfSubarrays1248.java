package com.zcy.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarrays1248 {
    //简单前缀和，
    //前缀和多用于解决连续子数组问题
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();//有几个奇数，有几次
        map.put(0,1);
        int sumOdd = 0;
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            sumOdd = nums[i]%2!=0 ? sumOdd+1:sumOdd;
            if(map.containsKey(sumOdd - k)){
                res+=map.get(sumOdd - k);
            }
            map.put(sumOdd,map.getOrDefault(sumOdd,0) + 1);
        }
        return res;
    }
}
