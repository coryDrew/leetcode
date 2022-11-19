package com.zcy.twoPoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {
    //自写
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i < len - 3;i++){
            if(i>0&&nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1;j < len - 2;j++){
                if(j>i+1&&nums[j] == nums[j-1]){//这里去重要注意  是j>i+1才开始判断，自己想出来的
                    continue;
                }
                int l = j+1,r = len - 1;
                while(l<r){
                    if(nums[i]+nums[j]+nums[l]+nums[r]!=-294967296&&nums[i]+nums[j]+nums[l]+nums[r] == target){
                        res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[l],nums[r])));
                        l++;r--;
                        while(l<r&&nums[l] == nums[l-1]) l++;
                        while(l<r&&nums[r] == nums[r + 1]) r--;
                    }else if(nums[i]+nums[j]+nums[l]+nums[r] > target){
                        r--;
                    }else{
                        l++;
                    }
                }



            }
        }
        return res;
    }
}
