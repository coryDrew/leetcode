package com.zcy.twoPoints;

import java.util.Arrays;

public class TriangleNumber611 {
    //类似三数之和，但是条件不一样
    //双指针的关键在于如何正确排除一些可能，并尽可能减小时间复杂度
    public int triangleNumber(int[] nums) {
        //两边之和大于第三边(用两个小边加起来)
        int res = 0;
        Arrays.sort(nums);
        for(int i = nums.length - 1;i>=2;i--){
            int target = nums[i];
            int l = 0,r = i - 1;
            while(l < r){
                if(nums[l] + nums[r] <= target){
                    l++;
                }else{
                    res += r - l;//后面的都行
                    r--;
                }
            }
        }
        return res;
    }
}
