package com.zcy.twoPoints;

import java.util.Arrays;

public class FindPairs532 {
    //自写，太乱了
    public int findPairs(int[] nums, int k) {
        //双指针
        Arrays.sort(nums);
        if(nums.length == 1)return 0;
        int l = 0,r = 1;
        int res = 0;
        while(r < nums.length){
            if(nums[r] - nums[l] == k){
                res++;
                if(nums[l] == nums[r]){
                    while(l < nums.length &&nums[l] == nums[r]){
                        l++;
                    }
                    r = l+1;
                }else{
                    l++;
                    while(l < nums.length&&nums[l] == nums[l -  1]){
                        l++;
                    }

                    r++;
                    while(r < nums.length&&nums[r] == nums[r -  1]){
                        r++;
                    }
                }
                continue;
            }
            if(nums[r] - nums[l] > k){
                l++;
                if(l == r){
                    r = l + 1;
                }
                continue;
            }
            if(nums[r] - nums[l] < k){
                r++;
            }

        }
        return res;
    }
    //官解
    public int findPairs1(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, y = 0, res = 0;
        for (int x = 0; x < n; x++) {
            if (x == 0 || nums[x] != nums[x - 1]) {
                while (y < n && (nums[y] < nums[x] + k || y <= x)) {
                    y++;
                }
                if (y < n && nums[y] == nums[x] + k) {
                    res++;
                }
            }
        }
        return res;
    }


}
