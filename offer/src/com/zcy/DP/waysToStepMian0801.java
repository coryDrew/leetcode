package com.zcy.DP;

public class waysToStepMian0801 {
    /**
     d[i-1] + d[i-2] 是不会越界的，因为d[i] < 1000000007, d[i-1] + d[i-2] + dp[i - 3] 是有可能越界的，所以需要对d[i-1] + d[i-2] 先取余
     */
    public int waysToStep(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        if(n == 0|| n == 1) return dp[n];
        dp[2] = 2;
        for(int i = 3;i <= n;i++){
            dp[i] = ((dp[i - 1]+dp[i - 2])%1000000007+dp[i - 3]) % 1000000007;
        }
        return dp[n];
    }
}
