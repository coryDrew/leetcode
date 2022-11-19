package com.zcy.array;

import java.util.Arrays;

public class NextPermutation31 {
    public static void main(String[] args) {
        nextPermutation(new int[]{2,3,1});
    }
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = -1;
        for(int i = len - 1;i > 0;i--){
            if(nums[i] >nums[i - 1]){
                index = i - 1;
                break;
            }
        }
        if(index == -1){
            Arrays.sort(nums);
            return;
        }
        for(int i = len - 1;i>index;i--){
            if(nums[i] >nums[index]){
                swap(nums,i,index);
                break;
            }

        }
        reverse(nums,index+1);
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
