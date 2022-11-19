package com.zcy.swm;

import java.util.Arrays;

public class CheckInclusion567 {
    //滑动窗口，不要陷入题目的思维，换个思路
    //只要每个字母的数量相同，那就说明s1的一种排列是s2的子串
    public boolean checkInclusion(String s1, String s2) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        if(s1.length()>s2.length())return false;
        for(int i = 0;i < s1.length();i++){
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(cnt1,cnt2))return true;
        for(int i = s1.length();i<s2.length();i++){
            cnt2[s2.charAt(i - s1.length()) - 'a']--;
            cnt2[s2.charAt(i) - 'a']++;
            if(Arrays.equals(cnt1,cnt2))return true;
        }
        return false;
    }
}
