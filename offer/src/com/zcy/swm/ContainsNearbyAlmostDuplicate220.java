package com.zcy.swm;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate220 {
    //滑动窗口+有序集合
    //有序集合！！！！空间换时间！！！想不出好的解就想想有什么数据结构能用
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
