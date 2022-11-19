package com.zcy.brainteasers;

public class NumSubarrayBoundedMax795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // 最大元素满足大于等于L小于等于R的子数组个数 = 最大元素小于等于R的子数组个数 - 最大元素小于L的子数组个数
        return subMax(nums,right) - subMax(nums,left -1);
    }
    //得记住
    public int subMax(int[] nums,int max){//最大元素小于等于max的子数组个数
        int res = 0;
        int numSub = 0;//每一阶段的个数，每当遇到一个大于max的数，直接清零
        for(int x:nums){
            if(x<=max){
                numSub++;
                res+=numSub;
            }else{
                numSub = 0;
            }
        }
        return res;
    }
}
