package com.zcy.string;

public class FindLUSlength522 {
    /**
     关键点：
     对于给定的某个字符串 \textit{str}[i]str[i]，如果它的一个子序列 \textit{sub}sub 是「特殊序列」，那么 \textit{str}[i]str[i] 本身也是一个「特殊序列」。

     这是因为如果 \textit{sub}sub 如果没有在除了 \textit{str}[i]str[i] 之外的字符串中以子序列的形式出现过，那么给 \textit{sub}sub 不断地添加字符，它也不会出现。而 \textit{str}[i]str[i] 就是 \textit{sub}sub 添加若干个（可以为零个）字符得到的结果。

     因此我们只需要使用一个双重循环，外层枚举每一个字符串 \textit{str}[i]str[i] 作为特殊序列，内层枚举每一个字符串 \textit{str}[j]~(i \neq j)str[j] (i
     
     ​
     =j)，判断 \textit{str}[i]str[i] 是否不为 \textit{str}[j]str[j] 的子序列即可。

     */
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            boolean check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isSubseq(String s, String t) {//贪心双指针
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        return ptS == s.length();
    }
}
