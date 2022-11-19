package com.zcy.DP;

import java.util.Arrays;

public class FindSubstringInWraproundString467 {
    //难受的一
    /**我们可以定义 \textit{dp}[\alpha]dp[α] 表示 pp 中以字符 \alphaα 结尾且在 ss 中的子串的最长长度，知道了最长长度，也就知道了不同的子串的个数。

     如何计算 \textit{dp}[\alpha]dp[α] 呢？我们可以在遍历 pp 时，维护连续递增的子串长度 kk。具体来说，遍历到 p[i]p[i] 时，如果 p[i]p[i] 是 p[i-1]p[i−1] 在字母表中的下一个字母，则将 kk 加一，否则将 kk 置为 11，表示重新开始计算连续递增的子串长度。然后，用 kk 更新 \textit{dp}[p[i]]dp[p[i]] 的最大值。


     */

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) { // 字符之差为 1 或 -25
                ++k;
            } else {
                k = 1;
            }
            dp[p.charAt(i) - 'a'] = Math.max(dp[p.charAt(i) - 'a'], k);
        }
        return Arrays.stream(dp).sum();
    }
}
