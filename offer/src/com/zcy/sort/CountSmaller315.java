package com.zcy.sort;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller315 {
    //左神归并排序模板基础上写
    //司马下标数组,不是人写的
    //记录当前元素与起始index关系    当前index[i]代表nums数组当前i位置元素在初始数组中的索引
    int[] index;
    //记录临时index关系，临时保存，每次进行覆盖
    int[] tempIndex;
    int[] temp;
    int[] ans;
    public List<Integer> countSmaller(int[] nums) {
        int length = nums.length;
        temp = new int[length];
        index = new int[length];
        tempIndex = new int[length];
        ans = new int[length];
        for (int i = 0; i < length; i++) {
            index[i] = i;
        }
        mergeSort(nums, 0, length - 1);
        List<Integer> list = new ArrayList<>(length);
        for (int count : ans) {
            list.add(count);
        }
        return list;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left == right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        if (nums[mid] > nums[mid + 1]){
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int l = left;
        int r = mid + 1;
        for (int i = left; i <= right; i++) {
            if (l == mid + 1){
                nums[i] = temp[r];
                tempIndex[i] = index[r];//现在nums数组i位置的数在初始数组中的下标为index[r]
                r++;
            } else if (r == right + 1){
                nums[i] = temp[l];
                ans[index[l]] += r - mid - 1;
                tempIndex[i] = index[l];
                l++;
            } else if (temp[l] <= temp[r]){
                nums[i] = temp[l];
                ans[index[l]] += r - mid - 1;
                tempIndex[i] = index[l];
                l++;
            } else {
                nums[i] = temp[r];
                tempIndex[i] = index[r];
                r++;
            }
        }
        for (int i = left; i <= right; i++) {
            index[i] = tempIndex[i];
        }
    }
}
