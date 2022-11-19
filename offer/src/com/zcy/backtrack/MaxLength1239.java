package com.zcy.backtrack;

import java.util.ArrayList;
import java.util.List;

public class MaxLength1239 {
    int ans = 0;

    public int maxLength(List<String> arr) {
        //masks是为了防止有的字符串内部就有相等的字符，把这部分字符串排除
        //每个字符串最后浓缩成了一个整数，太牛逼了
        List<Integer> masks = new ArrayList<Integer>();
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask > 0) {
                masks.add(mask);
            }
        }

        backtrack(masks, 0, 0);
        return ans;
    }

    public void backtrack(List<Integer> masks, int pos, int mask) {
        if (pos == masks.size()) {
            ans = Math.max(ans, Integer.bitCount(mask));//看有多少个1，nb
            return;
        }
        //如果这个数能选，则尝试选或者不选，如果不能选，那就只能不选
        if ((mask & masks.get(pos)) == 0) { // mask 和 masks[pos] 无公共元素
            backtrack(masks, pos + 1, mask | masks.get(pos));
        }
        backtrack(masks, pos + 1, mask);//这里传的是之前的mask，相当于回到了之前的状态，这题的回溯不像之前是把东西放在集合里，所以回溯的时候要删集合，这里就是数，把数恢复成之前传过去，就是回溯
    }
}
