package com.zcy.interview.swm;

public class lengthOfLongestSubstring3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1)return 1;
        HashSet<Character> set = new HashSet<>();
        int l = 0,r = 0;
        int res = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            if(!set.contains(ch)){
                set.add(ch);
            }else{
                res = Math.max(res,r - l);
                while(s.charAt(l) != ch){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.remove(s.charAt(l));
                l++;
                set.add(ch);
            }
            r++;
        }
        res = Math.max(res,r - l);
        return res;
    }
}
