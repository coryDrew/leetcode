package com.zcy.offertwo;

public class Offer009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0,n = nums.length;
        int prod = 1,res = 0;

        for(int j = 0;j < n;j++){//思路：算以j位置结尾有多少个，利用正整数性质
            prod*=nums[j];
            while(i<=j&&prod >= k){
                prod/=nums[i];
                i++;
            }
            res+=j - i + 1;
        }
        return res;
    }
}
