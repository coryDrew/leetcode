package com.zcy.interview.backtrack;

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses93 {
    List<String> list;
    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();
        backtrack(s,0,0,new int[4]);
        return list;
    }
    public void backtrack(String s,int start,int id,int[] ss){
        if(id == 4){
            if(start == s.length()){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j < 4;j++){
                    sb.append(ss[j]);
                    sb.append(".");
                }
                sb.deleteCharAt(sb.length() - 1);
                list.add(sb.toString());
            }
            return;
        }

        int sum = 0;
        for(int i = start;i < s.length();i++){
            if(s.charAt(start) == '0'){
                ss[id] = 0;
                backtrack(s,i+1,id+1,ss);
                break;
            }
            sum = sum*10 + s.charAt(i) - '0';
            if(sum > 0 && sum <= 255){
                ss[id] = sum;
                backtrack(s,i+1,id+1,ss);
            }else{
                break;
            }
        }
}
