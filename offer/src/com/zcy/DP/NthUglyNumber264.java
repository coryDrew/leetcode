package com.zcy.DP;

public class NthUglyNumber264 {
    //三指针，记住了
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p1 = 1,p2 = 1,p3 = 1;
        for(int i = 2;i <= n;i++){
            int num1 = dp[p1] * 2,num2 = dp[p2] * 3,num3 = dp[p3] * 5;
            dp[i] = Math.min(Math.min(num1,num2),num3);
            if(num1 == dp[i]){//只要相等，指针就增加，很容易忽略的细节，313题自己做时就忽略了
                p1++;
            }
            if(num2 == dp[i]){
                p2++;
            }
            if(num3 == dp[i]){
                p3++;
            }
        }
        return dp[n];
    }
}
