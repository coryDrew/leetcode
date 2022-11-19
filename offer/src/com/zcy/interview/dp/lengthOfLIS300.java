package com.zcy.interview.dp;

public class lengthOfLIS300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int res = -1;
        for(int i = 0;i < len;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
