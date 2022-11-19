package com.zcy.offertwo.important;

import java.util.ArrayList;
import java.util.List;

public class Offer081 {
    //无重复元素的正整数数组
    //注意去重，增加一个start就行
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(candidates,target,new ArrayList<>(),0,0);
        return res;
    }
    public void backtrack(int[] candidates,int target,List<Integer> list,int cur,int start){
        if(cur > target){
            return;
        }
        if(cur == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i < candidates.length;i++){
            list.add(candidates[i]);
            cur+=candidates[i];
            backtrack(candidates,target,list,cur,i);
            cur-=candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
