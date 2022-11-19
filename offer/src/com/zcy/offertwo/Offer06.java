package com.zcy.offertwo;

import java.util.HashMap;
import java.util.Map;

public class Offer06 {
    //自写哈希表，击败百分之11
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < numbers.length;i++){
            map.put(numbers[i],i);
        }
        int[] ans = new int[2];
        for(int i = 0;i < numbers.length;i++){
            if(map.containsKey(target - numbers[i])){
                ans[0] = i;
                ans[1] = map.get(target - numbers[i]);
                break;
            }
        }
        return ans;
    }
    //此题是升序数组，所以双指针最快！！！！
    public int[] twoSum1(int[] numbers, int target) {
        int l =0,r = numbers.length - 1;

        while(l < r){
            if(numbers[l]+numbers[r]<target){
                l++;
            }else if(numbers[l]+numbers[r]>target){
                r--;
            }else{
                return new int[]{l,r};
            }
        }
        return null;
    }
}
