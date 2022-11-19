package com.zcy.DP.stock;

public class MaxProfit122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp1 = new int[len];//在第i天不持有股票的最大收益
        int[] dp2 = new int[len];//在第i天持有股票的最大收益
        dp1[0] = 0;
        dp2[0] = -prices[0];
        int res = 0;
        for(int i = 1;i < len;i++){
            dp1[i] = Math.max(dp1[i - 1],dp2[i - 1] + prices[i]);
            dp2[i] = Math.max(dp2[i - 1],dp1[i - 1] - prices[i]);
            res = Math.max(dp1[i],res);
        }
        return res;
    }
}
