package com.zcy.BAG.completelyBAG;

import java.util.Arrays;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        //dp[i] 代表组成金额i需要的最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i = 1;i <= amount;i++){
            for(int j = 0;j < coins.length;j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i],dp[i - coins[j]]+1);
                }
            }
        }
        return dp[amount] == amount + 1? -1:dp[amount];
    }
}
