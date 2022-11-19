package com.zcy.tree.pathProblem;

import com.zcy.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumNumbers129 {
    //自写，和113统一思路，速度就很慢了，击败20，应该用官方的递归
    List<List<Integer>> res = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return -1;
        }
        dfs(root,new ArrayList<>());
        int sum = 0;
        for(List<Integer> list: res){
            int sumPart = 0;
            int pre = 0;
            for(int x:list){
                sumPart=x+pre*10;
                pre = sumPart;
            }
            sum+=sumPart;
        }
        return sum;
    }


    public void dfs(TreeNode root,List<Integer> list){
        list.add(root.val);
        if(root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
        }
        if(root.left != null){
            dfs(root.left,list);
        }
        if(root.right != null){
            dfs(root.right,list);
        }
        list.remove(list.size() - 1);
    }
    //*********************官方递归*******************************
    public int sumNumbers1(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }


}
