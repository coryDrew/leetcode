package com.zcy.twoPoints;

public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int j = 0;//记录非0元素放到哪个位置
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for(int i = j;i < nums.length;i++){
            nums[i] = 0;
        }

    }
}
