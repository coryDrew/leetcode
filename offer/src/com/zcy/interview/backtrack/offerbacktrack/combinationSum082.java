package com.zcy.interview.backtrack.offerbacktrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum082 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
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
            if(i != start && candidates[i] == candidates[i - 1]){//关键来啦
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates,target - candidates[i],i+1,list);
            list.remove(list.size() - 1);
        }
    }
}
