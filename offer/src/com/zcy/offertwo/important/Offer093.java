package com.zcy.offertwo.important;

import java.util.HashMap;
import java.util.Map;

public class Offer093 {
    //这些dp都写不出来！
    //难想
    //dp[i][j]定义为以arr[i]和arr[j]作为斐波那契式子序列最后两个数的子序列长度。
    // 例如arr = {2,3,4,5,7,8}，那么dp[3][5] = 4，表示斐式子序列{2,3,5,8}的长度为4。dp[2][4] = 3，表示斐式子序列{3,4,7}的长度为3。
    public static void main(String[] args) {
        lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8});
    }


    public static int lenLongestFibSubseq(int[] arr) {

        int max = 0, n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) { // 得到值与下标的映射
            map.put(arr[i], i);
        }
        int[][] dp = new int[n - 1][n]; // i一定小于j，所以第一维大小可以设为n-1
        for(int i = 0; i < n; i++){
            for(int k = i + 2; k < n; k++){ // k至少比i大2，因为中间要放下j
                int j = map.getOrDefault(arr[k] - arr[i], -1); // 获取满足arr[i]+arr[j]=arr[k]的j，不满足时j=-1
                if(i < j && j < k) { // j在i和k之间
                    dp[j][k] = dp[i][j] + 1;
                    max = Math.max(max, dp[j][k]);
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }
}
