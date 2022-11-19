package com.zcy.swm;

public class minSubArrayLen209 {
    //简单SWM
    public int minSubArrayLen(int target, int[] nums) {
        //滑动窗口
        int l = 0,r = 0;
        int sum = nums[l];
        int res = Integer.MAX_VALUE;
        while(r < nums.length){
            if(sum >= target){
                res = Math.min(res,r - l + 1);
                sum -= nums[l];
                l++;

            }else{
                r++;
                if(r < nums.length){
                    sum+=nums[r];
                }

            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
