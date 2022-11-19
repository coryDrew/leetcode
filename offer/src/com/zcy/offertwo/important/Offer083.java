package com.zcy.offertwo.important;

public class Offer083 {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums,new ArrayList<>());
        return res;
    }
    public void backtrack(int[] nums,List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(list.contains(nums[i]))continue;
            list.add(nums[i]);
            backtrack(nums,list);
            list.remove(list.size() - 1);
        }
    }
}
