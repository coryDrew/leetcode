package com.zcy.swm;

public class CharacterReplacement424 {
    /**
     2. maxCount 在内层循环「左边界向右移动一个位置」的过程中，没有维护它的定义，结论是否正确？
     答：结论依然正确。「左边界向右移动一个位置」的时候，maxCount 或者不变，或者值减 11。

     maxCount 的值虽然不维护，但数组 freq 的值是被正确维护的；
     当「左边界向右移动」之前：
     如果有两种字符长度相等，左边界向右移动不改变 maxCount 的值。例如 s = [AAABBB]、k = 2，左边界 A 移除以后，窗口内字符出现次数不变，依然为 33；
     如果左边界移除以后，使得此时 maxCount 的值变小，又由于 我们要找的只是最长替换 k 次以后重复子串的长度。接下来我们继续让右边界向右移动一格，有两种情况：① 右边界如果读到了刚才移出左边界的字符，恰好 maxCount 的值被正确维护；② 右边界如果读到了不是刚才移出左边界的字符，新的子串要想在符合题意的条件下变得更长，maxCount 一定要比之前的值还要更多，因此不会错过更优的解。
     */
    public int characterReplacement(String s, int k) {
        //确实不简单，细节太多了
        int len = s.length();
        if (len < 2) {
            return len;
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;

        int res = 0;
        int maxCount = 0;
        int[] freq = new int[26];
        // [left, right) 内最多替换 k 个字符可以得到只有一种字符的子串
        while (right < len){
            freq[charArray[right] - 'A']++;
            // 在这里维护 maxCount，因为每一次右边界读入一个字符，字符频数增加，才会使得 maxCount 增加
            maxCount = Math.max(maxCount, freq[charArray[right] - 'A']);
            right++;

            if (right - left > maxCount + k){
                // 说明此时 k 不够用
                // 把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
                // 移出滑动窗口的时候，频数数组须要相应地做减法
                freq[charArray[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);//左闭右开
        }
        return res;
    }
}
