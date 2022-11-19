package com.zcy.offertwo;

public class Offer088 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        if(len == 1) return cost[0];
        dp[len - 1] = cost[len - 1];
        dp[len - 2] = cost[len - 2];
        for(int i = len - 3;i >= 0;i--){


            dp[i] = Math.min(dp[i+1],dp[i+2])+cost[i];

        }
        return Math.min(dp[0],dp[1]);
    }
}
