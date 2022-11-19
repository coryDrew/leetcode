package com.zcy.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation784 {
    //自身问题：1.StringBuilder方法不熟悉，如delete
    //2.字符转化忘记加上char强转了！
    public static void main(String[] args) {
        letterCasePermutation("a1b2");
        System.out.println(res);
//        System.out.println("????");
//        System.out.println((char)('a'+32));
//        StringBuilder sb = new StringBuilder();
//        sb.append('a');
//        sb.delete(0,1);
//        System.out.println(sb);

    }
   static List<String> res;
    public static List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        backtrack(s,0,new StringBuilder());
        return res;
    }
    private static void backtrack(String s,int start,StringBuilder sb){
        if(sb.length() == s.length()){
            res.add(sb.toString());
            return;
        }
        if(Character.isDigit(s.charAt(start))){
            sb.append(s.charAt(start));
            backtrack(s,start+1,sb);
            sb.delete(sb.length() - 1,sb.length());
        }else{
            sb.append(s.charAt(start));
            backtrack(s,start+1,sb);
            sb.delete(sb.length() - 1,sb.length());
            if(Character.isUpperCase(s.charAt(start))){
                sb.append((char)(s.charAt(start)+32));
            }else{
                sb.append((char)(s.charAt(start)-32));
            }

            backtrack(s,start+1,sb);
            sb.delete(sb.length() - 1,sb.length());
        }
    }
}
