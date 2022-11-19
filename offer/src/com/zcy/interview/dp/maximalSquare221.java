package com.zcy.interview.dp;

public class maximalSquare221 {

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m][n];//以i j为左上角最终形成的正方形的最大边长
        for(int i = 0;i < n;i++){
            dp[m - 1][i] = matrix[m - 1][i] == 1 ? 1 : 0;
            res = Math.max(dp[m - 1][i],res);
        }
        for(int i = 0;i < m;i++){
            dp[i][n - 1] = matrix[i][n - 1] == 1 ? 1 : 0;
            res = Math.max(dp[i][n -1],res);
        }
        for(int i = m - 2;i>=0;i--){
            for(int j = n - 2;j>=0;j--){
                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j],dp[i][j + 1]),dp[i+1][j+1])+1;
                }else{
                    dp[i][j] = 0;
                }

                res = Math.max(res,dp[i][j]*dp[i][j]);
            }
        }
        return res;
    }
}
