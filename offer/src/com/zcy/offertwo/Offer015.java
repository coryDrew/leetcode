package com.zcy.offertwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer015 {
    //和14题基本一样的
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int m = s.length(),n = p.length();
        if(m < n){
            return list;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for(int i = 0;i < n;i++){
            cnt1[s.charAt(i) - 'a']++;
            cnt2[p.charAt(i) - 'a']++;
        }
        if(Arrays.equals(cnt1,cnt2)){
            list.add(0);
        }
        for(int i = n;i < m;i++){
            cnt1[s.charAt(i) - 'a']++;
            cnt1[s.charAt(i - n) - 'a']--;
            if(Arrays.equals(cnt1,cnt2)){
                list.add(i - n + 1);
            }
        }
        return list;
    }
}
