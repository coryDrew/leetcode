package com.zcy.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3T216 {
    //简单回溯，剪枝提升效率，自写击败100
    int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(arr,k,n,0,new ArrayList<>());
        return res;
    }
    private void backtrack(int[] arr,int k,int target,int start,List<Integer> list){
        if(list.size() == k){
            if(target == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i = start;i < arr.length;i++){
            if(arr[i] > target){
                break;
            }
            list.add(arr[i]);
            backtrack(arr,k,target - arr[i],i+1,list);
            list.remove(list.size() - 1);
        }
    }
}
