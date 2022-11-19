package com.zcy.math;

public class CountNumbersWithUniqueDigits357 {
    //从高位开始确定，后面每一位的选择余地比前一位少1！！！！！！！！
    //高中数学
    //这个题就是高中时学的排列组合
    //f(0)=1
    //f(1)=10
    //f(2)=9*9+f(1)
    //f(3)=9*9*8+f(2)
    //f(4)=9*9*8*7+f(3)
    //左边开始数
    //首位数不取 0 其他位数可以取 0，下一位比前一位取法少一种，因为不能重复
    //首位数取 0 时就是 f(n-1)的数量
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 10;
        for(int i = 2;i <= n;i++){
            int res = 9;
            int base = 9;
            for(int j = 2;j <= i;j++){
                res*=base;
                base--;
            }
            dp[i] = res + dp[i - 1];
        }
        return dp[n];
    }
}
