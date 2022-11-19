package com.zcy.offertwo.important;

public class Offer094 {
    public int minCut(String s) {
        int n = s.length();
        // 计算dp1 dp1[i][j] 代表i~j是否是回文
        boolean[][] dp1 = new boolean[n][n];
        for(int i = 0; i < n - 1; i++){
            dp1[i][i] = true; // 单个字符
            dp1[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? true : false; // 相邻两个字符
        }
        dp1[n - 1][n - 1] = true; // 补上最后一个单字符
        for(int i = n - 3; i >= 0; i--){//i减j增，因为用到的是i+1和j-1
            for(int j = i + 2; j < n; j++){
                dp1[i][j] = dp1[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        // 计算dp2
        int[] dp2 = new int[n];//代表0~i的最少分割次数
        Arrays.fill(dp2, Integer.MAX_VALUE); // 后面要取小，先置为无穷大
        for(int i = 0; i < n; i++){
            if(dp1[0][i]){ // 该条件成立时直接得到dp2[i] = 0
                dp2[i] = 0;
            }
            else{ // 否则需要在j为1到i之间遍历所有dp1[j][i]为回文串的情形，这一步最难想啊！
                for(int j = 1; j <= i; j++){
                    if(dp1[j][i]) dp2[i] = Math.min(dp2[i], dp2[j - 1] + 1);
                }
            }
        }
        return dp2[n - 1];
    }
}
