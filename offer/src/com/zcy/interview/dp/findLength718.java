package com.zcy.interview.dp;

public class findLength718 {
    public int findLength(int[] nums1, int[] nums2) {
        //和1143区别一下
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int res = 0;
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = 0;
                }
                res = Math.max(res,dp[i][j]);
            }

        }
        return res;
    }
}
