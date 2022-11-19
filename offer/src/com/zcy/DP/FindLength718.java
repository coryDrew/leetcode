package com.zcy.DP;

public class FindLength718 {
    //严格区分求最长公共子串和最长公共子序列
    //两个的dp定义完全不同！！！，一个以区间，一个以结尾
    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
    }
    public static int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        //dp[i][j]代表以 i -1 和j - 1 下标为结尾的最长子串
        //dp[0][0]dp[1][0]dp[0][1]无意义，默认为0
        //从dp[1][1]开始，代表以0,0为结尾的最长子串
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <=n; j++){
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int res = 0;
        for(int i = 0;i <= m;i++){
            for(int j = 0;j <= n;j++){
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
