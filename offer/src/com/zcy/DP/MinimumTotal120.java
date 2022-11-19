package com.zcy.DP;

import java.util.Arrays;
import java.util.List;

public class MinimumTotal120 {
    //自写77
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size() + 1][triangle.size()];
        for(int i = 0;i < dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);

        }
        dp[1][0] = triangle.get(0).get(0);
        for(int i = 2;i <= triangle.size();i++){//第i层
            for(int j = 0;j < i;j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j]+triangle.get(i - 1).get(j);
                }else{
                    dp[i][j]  = Math.min(dp[i - 1][j],dp[i - 1][j - 1])+triangle.get(i - 1).get(j);
                }

            }//第i层有i个数
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < triangle.size();i++){
            res = Math.min(dp[triangle.size()][i],res);
        }
        return res;
    }
    //官方优化空间
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }


}
