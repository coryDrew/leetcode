package com.zcy.offertwo.important;

import java.util.TreeSet;

public class offer057 {
    //滑动窗口+TreeSet
    //实现方面，我们在有序集合中查找大于等于 x - tx−t 的最小的元素 yy，如果 yy 存在，且 y \leq x + ty≤x+t，我们就找到了一对符合条件的元素

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0;i < n;i++){
            Long ceiling = set.ceiling((long)nums[i] - (long)t);
            if(ceiling != null&&ceiling<=(long)nums[i]+(long)t){
                return true;
            }
            set.add((long)nums[i]);
            if(i>=k){//维持set里k个元素
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
