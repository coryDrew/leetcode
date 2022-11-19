package com.zcy.offertwo.important;

public class Offer090 {
    public int rob(int[] nums) {
        //0~n - 1 or 1 - n
        int len = nums.length;
        if(len == 1)return nums[0];
        if(len == 2)return Math.max(nums[0],nums[1]);
        int[] dp1 = new int[len - 1];

        int[] dp2 = new int[len];//dp2代表1~n范围内 dp2[0]无意义
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1],nums[2]);
        for(int i = 2;i < len - 1;i++){
            dp1[i] = Math.max(dp1[i - 1],dp1[i - 2]+nums[i]);
        }
        for(int i = 3;i < len;i++){
            dp2[i] = Math.max(dp2[i - 1],dp2[i - 2]+nums[i]);
        }
        return Math.max(dp1[len - 2],dp2[len - 1]);
    }
}
