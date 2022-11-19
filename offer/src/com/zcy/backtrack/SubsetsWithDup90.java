package com.zcy.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup90 {
    //只有带重复数的全排列的去重比较复杂!!
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums,int start,List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i = start;i < nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]){//同层内避免重复数字即可，不要visited数组
                continue;
            }
            list.add(nums[i]);

            backtrack(nums,i+1,list);
            list.remove(list.size() - 1);

        }
    }
}
