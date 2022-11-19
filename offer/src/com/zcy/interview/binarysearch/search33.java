package com.zcy.interview.binarysearch;

public class search33 {
    //自己写出来咯
    public int search(int[] nums, int target) {
        //应该要和两边的数比较的
        int l = 0,r = nums.length - 1;
        while(l <= r){
            int mid = ((r - l) >> 1) + l;
            if(nums[mid] == target)return mid;
            if(nums[mid] >= nums[0]){
                if(nums[mid] >target){
                    if(target >= nums[0]){
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }else{
                    l = mid + 1;

                }
            }else{
                if(nums[mid] >target){
                    r = mid - 1;
                }else{
                    if(target <= nums[nums.length - 1]){
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
