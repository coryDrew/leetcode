package com.zcy.interview.backtrack;

import java.util.ArrayList;
import java.util.List;

public class subsets78 {
    //子集   不含重复
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums,0,new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums,int start,List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i = start;i < nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,i+1,list);
            list.remove(list.size() - 1);
        }
    }
}
