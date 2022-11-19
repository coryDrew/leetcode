package com.zcy.sort;

import java.util.Arrays;

public class WiggleSort324 {
    ///什么比东西
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();//这个函数可以学一学
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }
}
