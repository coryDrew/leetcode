package com.zcy.interview.backtrack.offerbacktrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique084 {
    //全排列都是0~length循环的，时间复杂度O(n×n!)
    List<List<Integer>> res;
    boolean[] visit;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        visit = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,visit,new ArrayList<>(),0);
        return res;
    }
    public void backtrack(int[] nums,boolean[] visit,List<Integer> list,int start){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(visit[i] ||i>0&& nums[i] == nums[i - 1] && !visit[i - 1]){
                continue;
            }
            visit[i] = true;
            list.add(nums[i]);
            backtrack(nums,visit,list,i+1);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }
}
