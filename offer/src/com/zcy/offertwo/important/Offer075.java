package com.zcy.offertwo.important;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Offer075 {
    //法一：定制排序
    //值得注意的是：Comparator中的类型是Integer，排序的数组也只能是Integer类型，不能够是int类型！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = arr2.length;
        for (int i = 0; i < length; i++) {
            map.put(arr2[i], i);
        }
        Integer[] a1 = new Integer[arr1.length];
        for(int i = 0;i < a1.length;i++){
            a1[i] = arr1[i];
        }
        Arrays.sort(a1,(o1,o2)->{
            if(map.containsKey(o1)&& map.containsKey(o2)){
                return map.get(o1) - map.get(o2);
            }
            if(map.containsKey(o1)){
                return -1;
            }
            if(map.containsKey(o2)){
                return 1;
            }else{
                return o1 - o2;
            }

                }
        );
        int[] res = new int[a1.length];
        for(int i = 0;i < res.length;i++){
            res[i] = a1[i];
        }
        return res;

    }
    //法二：计数，清零
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int upper = Integer.MIN_VALUE;
        for(int x:arr1){
            upper = Math.max(upper,x);
        }
        int []frequency = new int[upper+1];
        for(int x:arr1){
            frequency[x]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for(int x:arr2){
            for(int i = 0;i < frequency[x];i++){
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        for(int x = 0;x <= upper;x++){

            for(int i = 0;i< frequency[x];i++){
                ans[index++] = x;
            }

        }
        return ans;
    }
}
