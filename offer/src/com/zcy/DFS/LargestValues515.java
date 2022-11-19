package com.zcy.DFS;

import java.util.ArrayList;
import java.util.List;

public class LargestValues515 {
    //bfs简单，要练dfs，练dfs，就是练递归
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        dfs(res,root,0);
        return res;
    }
    public void dfs(List<Integer> res,TreeNode root,int curHeight){
        if(res.size() == curHeight){//第一次来这层
            res.add(root.val);
        }else{
            res.set(curHeight,Math.max(res.get(curHeight),root.val));
        }
        if(root.left != null){
            dfs(res,root.left,curHeight+1);
        }
        if(root.right != null){
            dfs(res,root.right,curHeight+1);
        }
    }
}
