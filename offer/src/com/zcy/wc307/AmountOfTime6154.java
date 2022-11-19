package com.zcy.wc307;

import java.util.*;

public class AmountOfTime6154 {
    //T3，medium，自写
    //bfs+dfs，先遍历一遍获取边的信息（建图），然后对图做宽度优先遍历
    int level = 0;
    boolean[] vis = new boolean[100001];
    Map<Integer,List<Integer>> map = new HashMap<>();//记录与key相邻的节点
    public int amountOfTime(TreeNode root, int start) {
        //把树变成图？
        dfs(root);
        //先遍历一遍，把节点之间的关系记录下来
        bfs(root,start);
        return level;
    }
    public void dfs(TreeNode root){
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
    public void bfs(TreeNode root,int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            for(int i = queue.size();i>0;i--){
                int x = queue.poll();
                vis[x] = true;
                List<Integer> list = map.get(x);
                if(list != null){
                    for(int t: list){
                        if(vis[t] == true){
                            continue;
                        }else{
                            queue.offer(t);
                        }
                    }
                }
            }

            if(!queue.isEmpty()){
                level++;
            }

        }
    }
}
