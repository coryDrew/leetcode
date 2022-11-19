package com.zcy.offertwo.important;

public class Offer096 {
    //边界条件，是真恶心
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (n + m != s3.length()) {
            return false;
        }
        boolean[][] isInter = new boolean[m+1][n+1];
        isInter[0][0] = true;// i j 代表s1的前i个和s2的前j个能否构成

        for(int i = 0;i < m+1;i++){
            for(int j = 0;j < n+1;j++){
                if(i > 0){
                    isInter[i][j] = isInter[i][j]||isInter[i - 1][j]&&s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                if(j > 0 ){
                    isInter[i][j] = isInter[i][j]||isInter[i][j - 1]&&s2.charAt(j - 1) == s3.charAt(i + j - 1);
                }

            }
        }
        return isInter[m][n];
    }
    /**这样写会导致错失   dp[i][0]和dp[0][j]
     for(int i = 1;i < m+1;i++){
     for(int j = 1;j < n+1;j++){
     if(s1.charAt(i - 1) == s3.charAt(i+j - 1)){
     isInter[i][j] = isInter[i - 1][j];
     }else if(s2.charAt(j - 1) == s3.charAt(i+j - 1)){
     isInter[i][j] = isInter[i][j - 1];
     }else{
     isInter[i][j] = false;
     }

     }
     }
     */

}
