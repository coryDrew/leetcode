package com.zcy.hash;

import java.util.*;

public class FrequencySort451 {
    public String frequencySort(String s) {
        //哈希表+list，妙啊
        //结合起来弥补了hash不能排序的缺陷
        //如果直接用TreeSMap呢，好像不太好整
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            int frequency = map.getOrDefault(c, 0) + 1;
            map.put(c, frequency);
        }
        List<Character> list = new ArrayList<Character>(map.keySet());//关键！！！！！！set赋给list
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));//list按频率降序排列
        StringBuffer sb = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int frequency = map.get(c);
            for (int j = 0; j < frequency; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
