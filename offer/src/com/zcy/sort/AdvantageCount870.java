package com.zcy.sort;

import java.util.Arrays;

public class AdvantageCount870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        //两个下标数组，通过下标对应的值对下标完成升序排序，下标对应的值越小，下标越靠前
        Integer[] index1 = new Integer[nums1.length];
        Integer[] index2 = new Integer[nums2.length];
        for(int i =0;i < index1.length;i++){//初始化
            index1[i] = i;
            index2[i] = i;
        }
        Arrays.sort(index1,(o1, o2)->nums1[o1] - nums1[o2]);
        Arrays.sort(index2,(o1,o2)->nums2[o1] - nums2[o2]);
        int[] res = new int[nums1.length];
        int left = 0,right = nums1.length - 1;

        for (int i = 0; i < nums1.length; ++i) {
            if (nums1[index1[i]] > nums2[index2[left]]) {
                res[index2[left]] = nums1[index1[i]];
                ++left;
            } else {
                res[index2[right]] = nums1[index1[i]];
                --right;
            }
        }
        return res;


    }
}
