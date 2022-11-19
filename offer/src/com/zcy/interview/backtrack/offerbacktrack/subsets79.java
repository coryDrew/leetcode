package com.zcy.interview.backtrack.offerbacktrack;

public class subsets79 {
    时间复杂度n*②的n次方
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
