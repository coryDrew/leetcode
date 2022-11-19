package com.zcy.offertwo.important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer082 {
    //写错啦！
    //含重复元素，结果中如何去重？
    //数组排序，
    // if(i > start && candidates[i] == candidates[i - 1])进行去重剪枝
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);//关键
        backtrack(candidates,new ArrayList<>(),target,0,0);
        return res;
    }
    public void backtrack(int[] candidates,List<Integer> list,int target,int cur,int start){
        if(cur == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(cur > target)return;
        for(int i = start;i < candidates.length;i++){
            if(i > start && candidates[i] == candidates[i - 1])
                continue; // 剪枝：i > start是关键，此时candidates[i]和candidates[i - 1]在同一层中.当以第二个1为开头是此时i是大于start的，所以直接过了，但是以第二个1作为集合中的第二个元素时，i是等于start的，所以不用continue
            list.add(candidates[i]);
            cur+=candidates[i];
            backtrack(candidates,list,target,cur,i+1);
            list.remove(list.size() - 1);
            cur-=candidates[i];
        }
    }
}
