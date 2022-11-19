package com.zcy.interview.hash;

public class firstMissingPositive41 {
    //原地修改，把每个数放到正确的位置//没想出来   hard
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0;i < len;i++){
            while(nums[i] > 0&& nums[i] <= len && nums[nums[i] - 1] != nums[i] ){//首先要大于零，其次不能太大，太大也不用移动
                swap(nums,i,nums[i] - 1);
            }
        }
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != i+1)return i+1;
        }
        return len + 1;
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
