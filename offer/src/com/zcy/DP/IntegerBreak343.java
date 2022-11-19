package com.zcy.DP;

public class IntegerBreak343 {
    //甚至没有想到dp！
    //先定出一个数j，剩下的就是子问题了！   很重要的思想
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i <= n;i++){
            for(int j = 1;j < i;j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i - j),j*dp[i - j]));
            }
        }
        return dp[n];
    }
    //数学思路以前见过，尽量使得出现更多的3即可！！
    //根据 nn 除以 33 的余数进行分类讨论：
    //
    //如果余数为 00，即 n=3m(m \ge 2)n=3m(m≥2)，则将 nn 拆分成 mm 个 33；
    //
    //如果余数为 11，即 n=3m+1(m \ge 1)n=3m+1(m≥1)，由于 2 \times 2 > 3 \times 12×2>3×1，因此将 nn 拆分成 m-1m−1 个 33 和 22 个 22；
    //
    //如果余数为 22，即 n=3m+2(m \ge 1)n=3m+2(m≥1)，则将 nn 拆分成 mm 个 33 和 11 个 22。
    //
    //上述拆分的适用条件是 n \ge 4n≥4。如果 n \le 3n≤3，则上述拆分不适用，需要单独处理。
    //
    //如果 n=2n=2，则唯一的拆分方案是 2=1+12=1+1，最大乘积是 1 \times 1=11×1=1；
    //
    //如果 n=3n=3，则拆分方案有 3=1+2=1+1+13=1+2=1+1+1，最大乘积对应方案 3=1+23=1+2，最大乘积是 1 \times 2=21×2=2。
    //数学思路的简单推理：
    //
    //对于 n >= 4，拆分后总是收益更大，因此最终所有 >= 4 的数都可以拆分为 2，3的组合（当然不可能有1）。
    //
    //而 2*2*2 < 3*3 ，2*2 > 3*1 ；因此拆分后所有的 2 三个一组合并为 3*3，剩下的2保留，最后计算乘积即可。

    public int integerBreakNB(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }
}
