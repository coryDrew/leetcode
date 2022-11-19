package com.zcy.DP;

public class GetMoneyAmount375 {
    //在一直猜错的情况下，最少要准备多少钱能赢？是这个意思吗

    //i == j时，f[i][j] == 0
    //似懂非懂
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = j + f[i][j - 1];
                for (int k = i; k < j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }
}
