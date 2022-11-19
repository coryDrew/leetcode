package com.zcy.DP.stock;

public class MaxProfit714 {
    public int maxProfit(int[] prices, int fee) {
        //dp[i][0]表示第i天没有股票的最大收益
        //dp[i][1]表示第i天持有股票的最大收益
        //也可以直接用两个dp数组表示
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];//最后一天没有股票的最大收益
    }
}
