package com.zcy.wc304;

import java.util.Arrays;

public class MinimumOperations6132 {
    //简单贪心
    public int minimumOperations(int[] nums) {
        //贪心？
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == 0){
                continue;
            }
            int tmp = nums[i];
            for(int j = i;j < nums.length;j++){
                nums[j]-=tmp;
            }
            res++;
        }
        return res;
    }
}
