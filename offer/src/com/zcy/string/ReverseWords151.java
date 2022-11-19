package com.zcy.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords151 {
    //自写击败66
    public String reverseWords(String s) {
        s.trim();
        StringBuilder sb1 = new StringBuilder();
        int index = 0;
        while(index < s.length()){
            if(s.charAt(index)!=' '){
                sb1.append(s.charAt(index));
                index++;
            }else{
                while(index < s.length()&&s.charAt(index) == ' '){
                    index++;
                }
                sb1.append(' ');
            }
        }
        String[] sArray = sb1.toString().split(" ");
        StringBuilder sb2 = new StringBuilder();
        for(int i = sArray.length - 1;i >=0;i--){
            sb2.append(sArray[i]);
            sb2.append(" ");
        }
        return sb2.toString().trim();
    }
    //***************官解正则表达式************************
    public String reverseWords1(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));//逆天
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }


}
