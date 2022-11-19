package com.zcy.prefixSum;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSubarraymian1705 {
    public String[] findLongestSubarray(String[] array) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int left = -1;
        int right = -1;
        int res = 0;
        for(int i = 0;i < array.length;i++){
            if(Character.isDigit(array[i].charAt(0))){
                sum--;
            }else{
                sum++;
            }
            if(map.containsKey(sum)){
                if(i-map.get(sum)>res){//这样不一定能保证返回左端点下标值最小吧？好像可以直接保证这个条件，自己分析一下
                    res = i-map.get(sum);
                    left = map.get(sum);
                    right = i;
                }


            }else{//只有不存在时才插入，因为要保证保存的都是下标最小的
                map.put(sum,i);
            }
        }
        String[] ans = new String[res];
        int index = 0;
        for(int i = left+1;i <= right;i++){
            ans[index++] = array[i];
        }
        return ans;
    }
}
