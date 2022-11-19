package com.zcy.DP.important;

public class LengthOfLIS300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];//i位置结尾的最长递增子序列
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[j],dp[i]);
                }

            }
            dp[i] += 1;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
