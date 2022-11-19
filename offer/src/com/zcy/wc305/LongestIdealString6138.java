package com.zcy.wc305;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIdealString6138 {
    //自写超时，悲哀
    //74/84
    //当dp超时时，应该怎么办？？？
    //看看别人怎么写的
    public int longestIdealString(String s, int k) {
        if(s.length() == 1){
            return 1;
        }
        int res = -1;
        int[] dp = new int[s.length()];//dp[i]表示以i位置为结尾的最长长度
        Arrays.fill(dp,1);
        for(int i = 1;i < s.length();i++){
            for(int j = 0;j < i;j++){
                if(Math.abs(s.charAt(i) - s.charAt(j)) <= k){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    //用map，太牛了，难想啊
    //但速度也一般
    //避免从0一直遍历到i
    public int longestIdealString666(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();//记录了当前遍历到的各个字母结尾的最长长度
        int[] dp = new int[s.length()];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            // 第二层循环最多 26 次
            for (int j = 0; j <= k; j++) {
                // 比 cur 少 j 的字母
                char t1 = (char) (cur - j);
                // 比 cur 多 j 的字母
                char t2 = (char) (cur + j);
                if (map.containsKey(t1)) {
                    dp[i] = Math.max(dp[i], map.get(t1) + 1);
                }
                if (map.containsKey(t2)) {
                    dp[i] = Math.max(dp[i], map.get(t2) + 1);
                }
            }
            // 更新以 cur 结尾的最长子序列的长度
            map.put(cur, dp[i]);//如果cur之间出现过，之间的最长长度肯定小于等于当前位置的最长长度，所以可以直接覆盖
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
