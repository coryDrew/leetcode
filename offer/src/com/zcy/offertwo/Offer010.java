package com.zcy.offertwo;

import java.util.HashMap;
import java.util.Map;

public class Offer010 {
    //O(n方)前缀和，1000ms
    public int subarraySum(int[] nums, int k) {
        int[] pre = new int[nums.length];
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            pre[i] = i-1>=0?pre[i-1]+nums[i]:nums[i];
            if(pre[i] == k){
                res++;
            }
        }
        for(int i = 0;i < nums.length - 1;i++){
            for(int j = i+1;j < nums.length;j++){
                if(pre[j] - pre[i] == k){
                    res++;
                }
            }
        }
        return res;
    }
    //前缀和+哈希，很关键，经常这俩一起用
    public int subarraySum1(int[] nums, int k) {
        int res = 0,pre = 0;
        Map<Integer,Integer> map = new HashMap<>();//键：前缀和，值：出现次数
        map.put(0,1);
        for(int i = 0;i < nums.length;i++){//O(n)
            pre+=nums[i];
            if(map.containsKey(pre - k)){
                res+=map.get(pre - k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return res;
    }
}
