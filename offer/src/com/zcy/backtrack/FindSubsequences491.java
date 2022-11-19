package com.zcy.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubsequences491 {
    //申请一个数据结构，进行同层去重,一定是同层！！！
    List<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        //还是回溯吧
        backtrack(nums,new ArrayList<>(),0);
        return res;
    }
    public void backtrack(int[] nums,List<Integer> list,int start){
        if(list.size() > 1){
            res.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();//同层去重！
        if(start == nums.length) return;
        for(int i = start;i < nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                continue;
            }

            if(list.size() == 0 || nums[i] >= list.get(list.size() - 1)){
                list.add(nums[i]);
                backtrack(nums,list,i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}
