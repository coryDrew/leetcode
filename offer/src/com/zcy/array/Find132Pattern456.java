package com.zcy.array;

import java.util.TreeMap;

public class Find132Pattern456 {
    //好题
    //treeMap一次动作耗时logn
    public boolean find132pattern(int[] nums) {
        //枚举“3”
        /**
         时间复杂度：O(n \log n)O(nlogn)。在初始化时，我们需要 O(n \log n)O(nlogn) 的时间将数组元素 a[2..n-1]a[2..n−1] 加入有序集合中。在枚举 jj 时，维护左侧元素最小值的时间复杂度为 O(1)O(1)，将 a[j+1]a[j+1] 从有序集合中删除的时间复杂度为 O(\log n)O(logn)，总共需要枚举的次数为 O(n)O(n)，因此总时间复杂度为 O(n \log n)O(nlogn)。

         */
        int n = nums.length;
        if(n < 3){
            return false;
        }
        int leftMin = nums[0];
        //这里左边必须用TreeMap，不能用map接口，因为map里没有ceilingKey方法！！！！！！！！！
        TreeMap<Integer,Integer> rightAll = new TreeMap<>();//右边所有的元素，key是数字，value是数字出现的次数
        for(int i = 2;i < nums.length;i++){
            rightAll.put(nums[i],rightAll.getOrDefault(nums[i],0)+1);
        }
        for(int i = 1;i < nums.length - 1;i++){
            if(nums[i] > leftMin){
                Integer rightmin = rightAll.ceilingKey(leftMin+1);//ceilingkey，大于的最小值，好方法，用的太少
                if(rightmin != null && rightmin < nums[i]){
                    return true;
                }
            }
            //动态维护
            leftMin = Math.min(leftMin,nums[i]);
            rightAll.put(nums[i + 1],rightAll.getOrDefault(nums[i + 1],0) - 1);
            if(rightAll.get(nums[i + 1]) == 0){
                rightAll.remove(nums[i + 1]);//map的remove方法，一直没用过，要注意
            }
        }
        return false;

    }
}
