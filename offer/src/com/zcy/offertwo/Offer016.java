package com.zcy.offertwo;

import java.util.HashSet;
import java.util.Set;

public class Offer016 {
    //官方滑动窗口
    //自己没想出来
    //主要是细节部分
    public int lengthOfLongestSubstring(String s) {
        int r = -1,ans = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0;i < s.length();i++){
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            while(r+1<s.length()&&!set.contains(s.charAt(r + 1))){
                set.add(s.charAt(r + 1));
                r++;
            }
            ans = Math.max(ans,r - i + 1);
        }
        return ans;
    }
}
