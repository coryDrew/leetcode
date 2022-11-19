package com.zcy.offertwo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Offer017 {
    //官方滑动窗口，细节太多了，挺恶心的
    //而且这个方法速度很慢
    Map<Character,Integer> ori = new HashMap<>();
    Map<Character,Integer> cnt = new HashMap<>();
    public String minWindow(String s,String t){
        int tlen = t.length();
        for(int i = 0;i < tlen;i++){
            ori.put(t.charAt(i),ori.getOrDefault(t.charAt(i),0)+1);
        }
        int l = 0,r = -1;
        int sLen = s.length();
        int len = Integer.MAX_VALUE,ansL = -1,ansR = -1;
        while(r <sLen){
            r++;
            if(r < sLen&&ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            }
            while(check()&&l<=r){
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = r+1;
                }
                if(ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l),cnt.get(s.charAt(l)) - 1);
                }
                l++;
            }

        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }
    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }







}
