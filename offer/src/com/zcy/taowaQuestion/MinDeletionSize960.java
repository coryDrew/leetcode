package com.zcy.taowaQuestion;

import java.util.Arrays;

public class MinDeletionSize960 {
    /*1.删除不好删，直接求最长的，符合条件的，非连续的，升序的，子串的，max长度

      2.答案 ====== word的长度 - max子串长度
      dp[i]代表以i列为结尾的最长长度，我表达的不太好，但意思就是最长递增子序列，只是要把所有行都考虑进去
    */
    public int minDeletionSize(String[] strs) {
        //自写
        int[] dp = new int[strs[0].length()];
        Arrays.fill(dp,1);
        int res = 0;
        for(int j = 0;j < dp.length;j++){
            for(int k = 0;k < j;k++){
                boolean flag = true;
                for(int i = 0;i < strs.length;i++){
                    if(strs[i].charAt(j) < strs[i].charAt(k)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    dp[j] = Math.max(dp[k]+1,dp[j]);
                }
            }
            res = Math.max(res,dp[j]);
        }
        return strs[0].length() - res;
    }
}
