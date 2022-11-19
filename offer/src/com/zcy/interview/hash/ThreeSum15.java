package com.zcy.interview.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    //注意点：第一个数字的重复性，二三数字的重复，下标越界问题
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i< len - 2;i++){
            if(i > 0 && nums[i] == nums[i - 1])continue;
            if(nums[i] > 0){
                break;
            }else{
                int l = i+1,r = len - 1;
                int target = -1*nums[i];
                while(l < r){
                    if(nums[l] + nums[r] == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[l]);
                        list.add(nums[r]);
                        list.add(nums[i]);
                        res.add(list);
                        //res.add(Arrays.asList(nums[i], nums[l], nums[r]));简写
                        l++;
                        r--;
                        while(l<len&&nums[l] == nums[l-1]){
                            l++;
                        }
                        while(r>=0&&nums[r] == nums[r+1]){
                            r--;
                        }
                    }else if(nums[l] + nums[r] > target){
                        r--;
                    }else if(nums[l] + nums[r] < target){
                        l++;
                    }
                }
            }

        }
        return res;
    }
}
