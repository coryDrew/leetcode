package com.zcy.wc302;

import java.util.*;

public class MaximumSum6164 {
    public int maximumSum(int[] nums) {
        //自己写的是事先排序的，速度没有别人的快
        /*
        预处理位数和+HashMap统计+贪心
        用长度为2的数组记录两个最大值
         */
        int n = nums.length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i], sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            // arr[0]最大值，arr[1]次大值
            int[] arr = map.getOrDefault(sum, new int[2]);
            if (nums[i] >= arr[0]) {
                arr[1] = arr[0];
                arr[0] = nums[i];
            } else if (nums[i] > arr[1]) {
                arr[1] = nums[i];
            }
            map.put(sum, arr);
        }
        int res = -1;
        for (int key : map.keySet()) {//keySet（）和values（）别忘记
            int[] arr = map.get(key);
            // 跳过数位和只有一个的情况
            if (arr[1] == 0) continue;
            res = Math.max(res, arr[0] + arr[1]);
        }
        return res;
    }
}
