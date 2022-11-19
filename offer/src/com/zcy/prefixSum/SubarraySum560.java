package com.zcy.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum560 {
    //这题是求个数，稍微不一样，还是很简单
    public int subarraySum(int[] nums, int k) {
        //返回的是个数
        Map<Integer,Integer> map = new HashMap<>();//第一个代表和，第二个代表个数
        int res = 0;
        int sum = 0;
        map.put(0,1);
        for(int i = 0;i < nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
