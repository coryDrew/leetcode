package com.zcy.offertwo;

import java.util.Arrays;

public class Offer032 {
    public boolean isAnagram(String s, String t) {
        if(s.equals(t) || s.length() != t.length()){
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(int i = 0;i < s.length();i++){
            arr1[s.charAt(i) - 'a']++;
            arr2[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(arr1,arr2);
    }
}
