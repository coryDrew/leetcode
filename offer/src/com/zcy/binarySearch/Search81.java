package com.zcy.binarySearch;

public class Search81 {
    //带重复元素，变恶心
    public boolean search(int[] nums, int target) {
        //二分
        int l = 0,r = nums.length - 1;
        while(l <= r){
            int mid = ((r - l)>>1)+l;
            if(target == nums[mid]){
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {//这里是关键，看官解
                ++l;
                --r;
            }else if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
