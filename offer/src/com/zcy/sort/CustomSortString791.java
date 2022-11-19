package com.zcy.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomSortString791 {
    //此题和Offer77基本一致
    ///定制排序，速度4ms
    public String customSortString(String order, String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < order.length();i++){
            map.put(order.charAt(i),i);
        }
        char[] ch = s.toCharArray();
        Character[] res = new Character[ch.length];
        for(int i = 0;i < ch.length;i++){
            res[i] = ch[i];
        }
        Arrays.sort(res,(o1, o2)->{
            if(map.containsKey(o1)&&map.containsKey(o2)){
                return map.get(o1) - map.get(o2);
            }else if(map.containsKey(o1)){
                return -1;
            }else if(map.containsKey(o2)){
                return 1;
            }else{
                return o1 - o2;
            }
        });
        for(int i = 0;i < ch.length;i++){
            ch[i] = res[i];
        }
        return new String(ch);
    }
    //计数排序，0ms
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        // 记录T中每个字符出现的次数
        int[] rec = new int[26];
        for(char c: T.toCharArray()){
            rec[c-'a']++;
        }
        // 遍历S，如果S中的字符也在T中，则将该字符全部加入
        for(char c: S.toCharArray()){
            if(rec[c-'a']!=0){
                for(int i=0;i<rec[c-'a'];i++){
                    sb.append(c);
                }
                rec[c-'a'] = 0;
            }
        }
        // 连接T剩下的在S中不存在的字符
        for(int i=0;i<rec.length;i++){
            if(rec[i]!=0){
                for(int j=0;j<rec[i];j++){
                    sb.append((char)(i+'a'));
                }
            }
        }
        return sb.toString();
    }
}
