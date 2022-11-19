package com.zcy.interview.sort;

public class MergeSort912 {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length - 1);
        return nums;
    }
    public void mergeSort(int[] nums,int i,int j){
        if(i >= j)return;
        int mid = ((j - i) >> 1) + i;
        mergeSort(nums,i,mid);
        mergeSort(nums,mid + 1,j);
        merge(nums,i,mid,j);
    }
    public void merge(int[] nums,int l,int mid,int r){
        int[] tmp = new int[r - l + 1];//关键哈
        int i = l,j = mid + 1;
        int index = 0;
        while(i <= mid && j <= r){
            if(nums[i] <= nums[j]){
                tmp[index++] = nums[i];
                i++;
            }else{
                tmp[index++] = nums[j];
                j++;
            }
        }
        while(i<=mid){
            tmp[index++] = nums[i++];
        }
        while(j<=r){
            tmp[index++] = nums[j++];
        }
        index = 0;
        for(int k = l;k <= r;k++){
            nums[k] = tmp[index++];
        }
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
