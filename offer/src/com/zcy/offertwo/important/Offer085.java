package com.zcy.offertwo.important;

import java.util.ArrayList;
import java.util.List;

public class Offer085 {
    //居然自己写出来了
    //两种情况往上加括号
    List<String> res;
    StringBuilder sb;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        sb = new StringBuilder();
        dfs(n,n);
        return res;
    }
    public void dfs(int left,int right){
        if(left == 0 && right == 0){
            res.add(new String(sb));
            return;
        }
        if(left > 0){
            sb.append("(");
            dfs(left - 1,right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(left < right){
            sb.append(")");
            dfs(left,right - 1);
            sb.deleteCharAt(sb.length() - 1);

        }
    }
}
