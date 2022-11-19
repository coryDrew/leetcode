package com.zcy.interview.binarysearch;

public class FindMin153 {
    public static int findMin(int[] nums){
        if(nums[nums.length - 1] > nums[0])return nums[0];
        int l = 0,r = nums.length - 1;
        while(l <= r){
            int mid = ((r - l) >> 1) + l;
            if((mid - 1 < 0||(nums[mid  - 1] > nums[mid]))
                    && (mid + 1 >= nums.length || nums[mid + 1] >nums[mid])){
                return nums[mid];
            }
            if(nums[mid] >= nums[0]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}
