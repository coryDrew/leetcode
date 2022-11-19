package com.zcy.divideandconqueralgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffWaysToCompute241 {
    Map<String, List<Integer>> map=new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        return dfs(expression);
    }
    public List<Integer> dfs(String str){//获得str的所有可能值
        int num=parseInt(str);
        if(num>=0){
            return new ArrayList<Integer>(){{add(num);}};
        }
        if(map.containsKey(str)){
            return map.get(str);
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<str.length();i++){//遍历每一个位置求可能性
            char ch=str.charAt(i);
            if(ch=='+' || ch=='-' || ch=='*'){
                List<Integer> left = dfs(str.substring(0,i));//左边的所有可能值
                List<Integer> right = dfs(str.substring(i+1));//右边的所有可能值
                int val=0;
                for(int l:left){
                    for(int r:right){
                        switch(ch){
                            case '+':
                                val=l+r;
                                break;
                            case '-':
                                val=l-r;
                                break;
                            case '*':
                                val=l*r;
                                break;
                            default:
                        }
                        res.add(val);
                    }
                }
            }
        }
        map.put(str, res);
        return res;
    }
    public int parseInt(String str){
        for(int i=0;i<str.length();i++){
            if(!Character.isDigit(str.charAt(i)))
                return -1;
        }
        return Integer.parseInt(str);
    }
}
