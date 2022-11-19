package com.zcy.wc303;

public class RepeatedCharacter6124 {
    //自写
    public char repeatedCharacter(String s) {
        int[] cnt = new int[26];
        char res = 'a';
        for(int i = 0;i < s.length();i++){
            cnt[s.charAt(i) - 'a']++;
            if(cnt[s.charAt(i) - 'a'] == 2){
                res = s.charAt(i);
                break;
            }
        }
        return res;
    }
}
