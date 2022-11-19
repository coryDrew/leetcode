package com.zcy.interview.backtrack.offerbacktrack;

import java.util.ArrayList;
import java.util.List;

public class combinationSum81 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();

        backtrack(candidates,target,0,new ArrayList<>());
        return res;
    }
    public void backtrack(int[] candidates,int target,int start,List<Integer> list){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0)return;
        for(int i = start;i < candidates.length;i++){
            list.add(candidates[i]);
            backtrack(candidates,target - candidates[i],i,list);
            list.remove(list.size() - 1);
        }
    }
}
