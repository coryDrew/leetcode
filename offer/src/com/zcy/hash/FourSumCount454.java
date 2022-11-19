package com.zcy.hash;

import java.util.HashMap;
import java.util.Map;

public class FourSumCount454 {
    //本题咋眼一看好像和0015.三数之和，0018.四数之和差不多，其实差很多。
    //
    //本题是使用哈希法的经典题目，而0015.三数之和，0018.四数之和并不合适使用哈希法，因为三数之和和四数之和这两道题目使用哈希法在不超时的情况下做到对结果去重是很困难的，很有多细节需要处理。
    //
    //而这道题目是四个独立的数组，只要找到A[i] + B[j] + C[k] + D[l] = 0就可以，不用考虑有重复的四个元素相加等于0的情况，所以相对于题目18. 四数之和，题目15.三数之和，还是简单了不少！
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums1.length;i++){//如果用增强for循环好像会提升速度啊！
            for(int j = 0;j < nums2.length;j++){
                map.put(nums1[i]+nums2[j],map.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }
        int res = 0;
        for(int i = 0;i < nums3.length;i++){
            for(int j = 0;j < nums4.length;j++){
                if(map.containsKey(0-(nums3[i]+nums4[j]))){
                    res+=map.get(0-(nums3[i]+nums4[j]));
                }
            }
        }
        return res;
    }
}
