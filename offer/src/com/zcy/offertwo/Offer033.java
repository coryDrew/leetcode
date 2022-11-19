package com.zcy.offertwo;

import java.util.*;

public class Offer033 {
    //hash,利用排序
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String newStr = new String(ch);
            if(!map.containsKey(newStr)){//提升速度的关键
                map.put(newStr,new ArrayList<>());

            }
            map.get(newStr).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> list:map.values()){
            res.add(list);
        }
        return res;
    }
}
