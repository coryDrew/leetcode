package com.zcy.bitwise;

import java.util.Arrays;

public class LongestSubarray6189 {
    public static void main(String[] args) {
        int[] arr = new int[]{311155,311155,311155,311155,311155,311155,311155,311155,201191,311155};
        longestSubarray(arr);

    }
    public static int longestSubarray(int[] nums) {
        //找连续的最大值
        int max =-1;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        int res = 0;

        int i = 0;
        while(i < nums.length){
            if(nums[i] == max){
                int cnt = 0;
                while(i < nums.length&&nums[i] == max){
                    cnt++;
                    i++;
                }
                res = Math.max(res,cnt);
            }
            i++;
        }
        return res;
    }
}
