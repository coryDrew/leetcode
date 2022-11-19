package com.zcy.string;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindLongestWord524 {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary,new Comparator<String>(){
            public int compare(String s1,String s2){
                if(s1.length() != s2.length()){
                    return s2.length() - s1.length();
                }else{
                    return s1.compareTo(s2);
                }
            }
        });
        int res = 0;
        for(String t:dictionary){
            int j = 0;
            for(int i = 0;i < s.length();i++){
                if(t.charAt(j) == s.charAt(i)){
                    j++;
                }
                if(j == t.length()){
                    return t;
                }
            }

        }
        return "";
    }
}
