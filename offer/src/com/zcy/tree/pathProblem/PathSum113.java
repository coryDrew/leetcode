package com.zcy.tree.pathProblem;

import com.zcy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum113 {
    //自写dfs，其实就是回溯，击败99
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return new ArrayList<>();
        }
        dfs(root,targetSum,new ArrayList<>());
        return res;
    }
    public void dfs(TreeNode root,int targetSum,List<Integer> list){
        list.add(root.val);
        if(root.val == targetSum&&root.left == null && root.right == null){
            res.add(new ArrayList<>(list));

        }
        if(root.left != null){
            dfs(root.left,targetSum - root.val,list);
        }
        if(root.right != null){
            dfs(root.right,targetSum - root.val,list);
        }
        list.remove(list.size() - 1);
    }
}
