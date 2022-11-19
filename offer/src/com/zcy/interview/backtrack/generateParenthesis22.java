package com.zcy.interview.backtrack;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis22 {
    //括号生成
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrack(n,n,new StringBuilder());
        return res;
    }
    public void backtrack(int left,int right,StringBuilder sb){
        if(left == 0 && right == 0){
            res.add(sb.toString());
        }
        if(left > 0){
            sb.append("(");
            backtrack(left - 1,right,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(left < right){
            sb.append(")");
            backtrack(left,right - 1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
