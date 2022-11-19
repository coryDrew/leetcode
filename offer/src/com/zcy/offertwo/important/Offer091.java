package com.zcy.offertwo.important;

public class Offer091 {
    //在动态规划和dfs之间犹豫？
    public int minCost(int[][] costs) {
        int[][] dp = new int[costs.length][3];
        //dp[i][j] 表示第i朵花选择第j种颜色时，前i朵花的最少花费
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i = 1;i < costs.length;i++){
            dp[i][0] = Math.min(dp[i - 1][1],dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0],dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0],dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(Math.min(dp[costs.length - 1][0],dp[costs.length - 1][1]),dp[costs.length - 1][2]);
    }
}
