package com.zcy.swm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRepeatedDnaSequences187 {
    //滑动+哈希，没有技术含量
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int l = 0,r = 10;
        Map<String,Integer> map = new HashMap<>();
        while(r <= s.length()){
            String str = s.substring(l,r);
            map.put(str,map.getOrDefault(str,0)+1);
            l++;
            r++;
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() >= 2){
                res.add(entry.getKey());
            }
        }
        return res;
    }
    //***********************************************
    //官方小优化，即只将个数为2的添加到答案，避免了重复添加，也避免了二次遍历
    static final int L = 10;

    public List<String> findRepeatedDnaSequences1(String s) {
        List<String> ans = new ArrayList<String>();
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        int n = s.length();
        for (int i = 0; i <= n - L; ++i) {
            String sub = s.substring(i, i + L);
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            if (cnt.get(sub) == 2) {
                ans.add(sub);
            }
        }
        return ans;
    }
    //****************************************************
    //官方位运算，看看得了
    Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> ans = new ArrayList<String>();
        int n = s.length();
        if (n <= L) {
            return ans;
        }
        int x = 0;
        for (int i = 0; i < L - 1; ++i) {
            x = (x << 2) | bin.get(s.charAt(i));
        }
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int i = 0; i <= n - L; ++i) {
            x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
            if (cnt.get(x) == 2) {
                ans.add(s.substring(i, i + L));
            }
        }
        return ans;
    }



}
