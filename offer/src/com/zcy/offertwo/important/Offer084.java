package com.zcy.offertwo.important;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer084 {
    //含重复数字求全排列，这个最难得
    //1排序2visit数组去重
    List<List<Integer>> res;
    boolean[] visit;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        visit = new boolean[nums.length];
        backtrack(nums,new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums,List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(visit[i] || i != 0&& nums[i] == nums[i - 1] && !visit[i - 1])//关键一步
                continue;
            list.add(nums[i]);
            visit[i] = true;
            backtrack(nums,list);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }
}
