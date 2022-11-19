package com.zcy.interview.backtrack.offerbacktrack;

import java.util.ArrayList;
import java.util.List;

public class combine80 {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if(n<k)return res;
        backtrack(n,k,1,new ArrayList<>());
        return res;
    }
    public void backtrack(int n,int k,int start,List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i <= n;i++){
            list.add(i);
            backtrack(n,k,i+1,list);
            list.remove(list.size() - 1);
        }
    }
}
