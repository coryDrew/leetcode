package com.zcy.offertwo.important;

public class Offer097 {
    //还是hard呢
    public int numDistinct(String s, String t) {

        if(s.length() < t.length()) return 0; // s长度小于t时，s中不会出现t
        int ns = s.length(), nt = t.length();
        //立刻定义dp[i][j]: s的前i个字符中的t的前j个字符的子序列个数。
        char[] chss = s.toCharArray(), chst = t.toCharArray();
        int[][] dp = new int[ns + 1][nt + 1];
        for(int i = 0; i <= ns; i++) dp[i][0] = 1;
        for(int i = 1; i <= ns; i++){
            for(int j = 1; j <= nt; j++){
                dp[i][j] = dp[i - 1][j] + (chss[i - 1] == chst[j - 1] ? dp[i - 1][j - 1] : 0);
            }
        }
        return dp[ns][nt];
    }
}
