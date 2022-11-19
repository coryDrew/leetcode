package com.zcy.offertwo.important;

import java.util.ArrayList;
import java.util.List;

public class Offer079 {
    //简单回溯，但一定要写的快
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums,new ArrayList<>(),0);
        return res;
    }
    public void backtrack(int[] nums,List<Integer> list,int start){
        res.add(new ArrayList<>(list));
        for(int i = start;i < nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,list,i+1);
            list.remove(list.size() - 1);
        }
    }
}
