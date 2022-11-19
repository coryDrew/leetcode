package com.zcy.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceK863 {
    //dfs建图，bfs求距离
    Map<Integer,List<Integer>> map = new HashMap<>();//记录与key相邻的节点
    List<Integer> res = new ArrayList<>();
    boolean[] vis = new boolean[501];
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(k == 0){
            res.add(target.val);
            return res;
        }
        dfs(root);
        bfs(target.val,k,0);
        return res;
    }
    public void dfs(TreeNode root){//dfs建图
        if(root == null) return;
        if(root.left != null){
            if(map.get(root.val) == null){
                map.put(root.val,new ArrayList<>());
            }
            if(map.get(root.left.val) == null){
                map.put(root.left.val,new ArrayList<>());
            }
            map.get(root.val).add(root.left.val);
            map.get(root.left.val).add(root.val);

        }
        if(root.right != null){
            if(map.get(root.val) == null){
                map.put(root.val,new ArrayList<>());
            }
            if(map.get(root.right.val) == null){
                map.put(root.right.val,new ArrayList<>());
            }
            map.get(root.val).add(root.right.val);
            map.get(root.right.val).add(root.val);
        }
        dfs(root.left);
        dfs(root.right);
    }
    public void bfs(int value,int k,int dis){
        List<Integer> list = map.get(value);
        vis[value] = true;
        dis++;
        if(list != null){
            if(dis == k){
                for(int i: list){
                    if(!vis[i]){
                        res.add(i);
                        vis[i] = true;
                    }

                }
                return;
            }
            else{
                for(int i: list){
                    if(!vis[i]){
                        bfs(i,k,dis);
                    }

                }

            }
        }

    }
}
