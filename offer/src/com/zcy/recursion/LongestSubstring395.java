package com.zcy.recursion;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring395 {
    //看似能用滑动窗口，实则非常难写，递归更好
    //精选评论，写的更简单，但规范上不如官解
    /*解题思路
本题要求的一个最长的子字符串的长度，该子字符串中每个字符出现的次数都最少为 kk。

求最长子字符串/区间的这类题一般可以用滑动窗口来做，但是本题滑动窗口的代码不好写，我改用递归。也借本题来帮助大家理解递归。

重点：我们在调用递归函数的时候，把递归函数当做普通函数（黑箱）来调用，即明白该函数的输入输出是什么，而不用管此函数内部在做什么。
下面是详细讲解。

递归最基本的是记住递归函数的含义（务必牢记函数定义）：本题的 longestSubstring(s, k) 函数表示的就是题意，即求一个最长的子字符串的长度，该子字符串中每个字符出现的次数都最少为 kk。函数入参 ss 是表示源字符串；kk 是限制条件，即子字符串中每个字符最少出现的次数；函数返回结果是满足题意的最长子字符串长度。

递归的终止条件（能直接写出的最简单 case）：如果字符串 ss 的长度少于 kk，那么一定不存在满足题意的子字符串，返回 0；

调用递归（重点）：如果一个字符 cc 在 ss 中出现的次数少于 kk 次，那么 ss 中所有的包含 cc 的子字符串都不能满足题意。所以，应该在 ss 的所有不包含 cc 的子字符串中继续寻找结果：把 ss 按照 cc 分割（分割后每个子串都不包含 cc），得到很多子字符串 tt；下一步要求 tt 作为源字符串的时候，它的最长的满足题意的子字符串长度（到现在为止，我们把大问题分割为了小问题(ss → tt)）。此时我们发现，恰好已经定义了函数 longestSubstring(s, k) 就是来解决这个问题的！所以直接把 longestSubstring(s, k) 函数拿来用，于是形成了递归。

未进入递归时的返回结果：如果 ss 中的每个字符出现的次数都大于 kk 次，那么 ss 就是我们要求的字符串，直接返回该字符串的长度。

总之，通过上面的分析，我们看出了：我们不是为了递归而递归。而是因为我们把大问题拆解成了小问题，恰好有函数可以解决小问题，所以直接用这个函数。由于这个函数正好是本身，所以我们把此现象叫做递归。小问题是原因，递归是结果。而递归函数到底怎么一层层展开与终止的，不要用大脑去想，这是计算机干的事。我们只用把递归函数当做一个能解决问题的黑箱就够了，把更多的注意力放在拆解子问题、递归终止条件、递归函数的正确性上来。

希望我说的这些能对你理解递归有所帮助。

作者：fuxuemingzhu
链接：https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/solution/jie-ben-ti-bang-zhu-da-jia-li-jie-di-gui-obla/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public int longestSubstring(String s, int k) {
        if(s.length() < k) return 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i = 0;i < s.length();i++){
            if(map.get(s.charAt(i))<k){
                int res = 0;
                for(String t:s.split(String.valueOf(s.charAt(i)))){
                    res = Math.max(res,longestSubstring(t,k));
                }
                return res;
            }
        }
        return s.length();
    }

    //官解
    public int longestSubstring1(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }

}
