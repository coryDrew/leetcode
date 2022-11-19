package com.zcy.offertwo.important;

import java.util.List;

public class Offer100 {
    //和前面几题没本质区别
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> last = triangle.get(triangle.size() - 1);
        int len = last.size();
        int[][] dp = new int[len][len];
        int[][] arr = new int[len][len];
        for(int i = 0;i < len;i++){
            List<Integer> list = triangle.get(i);
            int s = list.size();
            for(int j = 0;j < len;j++){
                if(j < s){
                    arr[i][j] = list.get(j);
                }else{
                    arr[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i = 0;i < len;i++) dp[len - 1][i] = arr[len - 1][i];
        for(int i = len - 2;i >= 0;i--){
            for(int j = triangle.get(i).size() - 1;j >= 0;j--){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+arr[i][j];
            }
        }
        return dp[0][0];
    }
}
