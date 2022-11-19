package com.zcy.interview.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PathSum113 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if(root == null)return res;
        bactrack(root,targetSum,new ArrayList<>());
        return res;
    }
    public void bactrack(TreeNode root,int targetSum,List<Integer> list){
        if(root.val == targetSum && root.left == null && root.right == null){
            list.add(root.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(root.val);
        if(root.left != null){
            bactrack(root.left,targetSum - root.val,list);
        }
        if(root.right != null){
            bactrack(root.right,targetSum - root.val,list);
        }
        list.remove(list.size() - 1);
    }
}
