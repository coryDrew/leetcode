package com.zcy.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength525 {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int res = 0;
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 1){
                sum++;
            }else{
                sum--;
            }
            if(map.containsKey(sum)){
                res = Math.max(res,i - map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return res;
    }
}
