package com.zcy.DP;

public class NthSuperUglyNumber313 {
    //自写，用个指针数组就行了，开long
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pArr = new int[primes.length];//指针数组
        long[] dp = new long[n];
        dp[0] = 1;
        for(int i = 1;i < n;i++ ){
            long min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j = 0;j < primes.length;j++){
                min = Math.min(dp[pArr[j]]*primes[j],min);
            }
            dp[i] = min;
            for(int j = 0;j < primes.length;j++){
                if(min == dp[pArr[j]]*primes[j]) pArr[j]++;
            }

        }
        return (int)dp[n - 1];
    }
}
