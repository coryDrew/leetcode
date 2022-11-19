package com.zcy.interview.dp;

public class maxProfit121 {
    //无意义dp
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];//第i天的最大收益
        dp[0] = 0;
        int res = 0;
        int min = prices[0];
        for(int i = 1;i < prices.length;i++){
            min = Math.min(min,prices[i]);
            dp[i] = Math.max(dp[i - 1],prices[i] - min);
        }
        return dp[prices.length - 1];
    }
}
