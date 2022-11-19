package com.zcy.DP.stock;

public class MaxProfit121 {
    //刷900题还是不会
    //动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];//第i天的最大收益
        dp[0] = 0;
        int res = 0;
        int min = prices[0];
        for(int i = 1;i < prices.length;i++){
            min = Math.min(min,prices[i]);
            dp[i] = Math.max(dp[i - 1],prices[i] - min);
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
