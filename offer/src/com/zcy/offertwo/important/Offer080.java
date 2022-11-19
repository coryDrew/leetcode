package com.zcy.offertwo.important;

import java.util.ArrayList;
import java.util.List;

public class Offer080 {
    //和79基本一样
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrack(n,k,new ArrayList<>(),1);
        return res;
    }
    public void backtrack(int n,int k,List<Integer> list,int start){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i <= n;i++){
            list.add(i);
            backtrack(n,k,list,i+1);
            list.remove(list.size() - 1);
        }

    }
}
