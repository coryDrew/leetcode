package com.zcy.swm;

import java.util.HashMap;
import java.util.Map;

public class MaxFreq1297 {
    public static void main(String[] args) {
        int s = maxFreq("aababcaab",2,3,4);
        System.out.println(s);
    }
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        //"abc" 肯定会覆盖 a, ab, 即长的肯定会覆盖短的,只要考虑最短的就好咯.
        //纯sb
        Map<String,Integer> map = new HashMap<>();
        int cnt = 1;//记录不同字母的个数；
        Map<Character,Integer> letter = new HashMap<>();//记录当前窗口内每个字母出现的次数
        int l = 0,r = 1;
        char[] ch = s.toCharArray();
        letter.put(ch[0],1);
        int res = 0;
        while(r < minSize){
            if(!letter.containsKey(ch[r])){
                letter.put(ch[r],1);
                cnt++;
            }else{
                letter.put(ch[r],letter.get(ch[r])+1);
            }
            r++;
        }
        if(cnt <= maxLetters){
            map.put(s.substring(0,minSize),1);
        }
        //处理左边出一个，右边进一个
        while(r < ch.length){//刚一进来r == minsize,l == 0
            letter.put(ch[l],letter.get(ch[l]) - 1);
            if(letter.get(ch[l]) == 0){
                cnt--;
                letter.remove(ch[l]);
            }
            l++;
            if(!letter.containsKey(ch[r])){
                letter.put(ch[r],1);
                cnt++;
            }else{
                letter.put(ch[r],letter.get(ch[r])+1);
            }
            r++;
            if(cnt <= maxLetters){
                map.put(s.substring(l,r),map.getOrDefault(s.substring(l,r),0)+1);
                res = Math.max(res,map.get(s.substring(l,r)));
            }



        }
        return res;
    }
}
