package com.zcy.interview.binarysearch;

public class findPeakElement162 {
    //没写出来！沾点玄学
    public int findPeakElement(int[] nums) {
        int l = 0,r = nums.length - 1;
        while(l < r){
            int mid = ((r - l) >> 1) + l;
            if(nums[mid] >= nums[mid + 1]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }
}
