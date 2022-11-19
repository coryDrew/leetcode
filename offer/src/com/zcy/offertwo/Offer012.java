package com.zcy.offertwo;

public class Offer012 {
    //简单题
    public int pivotIndex(int[] nums) {
        //前缀和与后缀和
        int n = nums.length;
        int[] pre = new int[n];
        int[] back = new int[n];
        for(int i = 0;i < n;i++){
            pre[i] = i>0?pre[i - 1]+nums[i]:nums[0];
        }
        for(int i = n - 1;i >= 0;i--){
            back[i] = i < n - 1?back[i + 1]+nums[i]:nums[n - 1];
        }
        for(int i = 0;i < n;i++){
            int left = i > 0?pre[i - 1]:0;
            int right = i < n - 1?back[i+1]:0;
            if(left == right){
                return i;
            }
        }
        return -1;
    }
}
