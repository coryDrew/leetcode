package com.zcy.interview.string;

public class longestCommonPrefix14 {
    public static String longestCommonPrefix(String[] arr){
        String pre = arr[0];
        for(int i = 1;i < arr.length;i++){
            pre =  prefix(pre,arr[i]);
        }
        return pre;
    }
    public static String prefix(String s1,String s2){
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) != s2.charAt(j))return sb.toString();
            sb.append(s1.charAt(i));
            i++;
            j++;
        }
        return sb.toString();
    }
}
