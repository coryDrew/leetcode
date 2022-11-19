package com.zcy.sort;

public class ReversePairsOffer51 {
    //左神模板改的，这里稍微不好的一点是会修改传进来的数组
    int count;
    public int reversePairs(int[] nums) {
        this.count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    public void mergeSort(int[] nums, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (left < right) {
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] temparr = new int[right - left + 1];
        int index = 0;
        int temp1 = left, temp2 = mid + 1;

        while (temp1 <= mid && temp2 <= right) {
            if (nums[temp1] <= nums[temp2]) {
                temparr[index++] = nums[temp1++];
            } else {
                //用来统计逆序对的个数
                count += (mid - temp1 + 1);
                temparr[index++] = nums[temp2++];
            }
        }
        //把左边剩余的数移入数组
        while (temp1 <= mid) {
            temparr[index++] = nums[temp1++];
        }
        //把右边剩余的数移入数组
        while (temp2 <= right) {
            temparr[index++] = nums[temp2++];
        }
        //把新数组中的数覆盖nums数组
        for (int k = 0; k < temparr.length; k++) {
            nums[k + left] = temparr[k];
        }
    }
}
