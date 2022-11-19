package com.zcy.offertwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer007 {
    //排序双指针，很多去重细节
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length <= 2){
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0;i < n;i++){
            if(nums[i]>0){
                continue;
            }
            if(i > 0 &&nums[i] == nums[i - 1]){
                continue;
            }
            int target = -nums[i];
            int l = i + 1,r = n - 1;
            while(l < r){
                if(nums[l] + nums[r] == target){
                    res.add(new ArrayList(Arrays.asList(nums[i],nums[l],nums[r])));
                    r--;
                    l++;
                    while(l<r&& nums[l-1] == nums[l]){
                        l++;
                    }
                    while(l<r&& nums[r+1] == nums[r]){
                        r--;
                    }

                }else if(nums[l]+nums[r] < target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }
}
