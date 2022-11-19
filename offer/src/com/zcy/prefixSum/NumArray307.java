package com.zcy.prefixSum;

public class NumArray307 {
    //击败7
    //更好的方法是线段树以及树状数组
    int[] nums;
    int[] preSum;
    public NumArray307(int[] nums) {
        this.nums = nums;
        preSum = new int[nums.length];
        preSum[0] = nums[0];
        for(int i = 1;i < nums.length;i++){
            preSum[i] = preSum[i - 1] + nums[i];
        }
    }

    public void update(int index, int val) {
        for(int i = index;i < nums.length;i++){
            preSum[i]+=val - nums[index];
        }
        nums[index]  = val;

    }

    public int sumRange(int left, int right) {
        return preSum[right] - preSum[left] +nums[left];
    }
}
