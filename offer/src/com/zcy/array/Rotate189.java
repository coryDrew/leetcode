package com.zcy.array;

import java.util.Arrays;

public class Rotate189 {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
    //*******************翻转数组方法***********************
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }



    //自写错的，右移次数比较多就错了
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotatewrong(int[] nums, int k) {
        int[] dup = new int[nums.length*2];
        for(int i = 0;i < dup.length;i++){
            dup[i] = nums[i%(nums.length)];
        }
        int index = 0;
        int n = nums.length;
        for(int i = n - k;i < 2*n - k - 1;i++){
            nums[index++] = dup[i];
        }
    }
}
