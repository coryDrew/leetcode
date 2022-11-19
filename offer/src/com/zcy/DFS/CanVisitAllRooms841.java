package com.zcy.DFS;

import java.util.List;

public class CanVisitAllRooms841 {
    //简单dfs
    boolean[] vis;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        vis = new boolean[rooms.size()];
        dfs(rooms,0);
        for(int i = 0;i<vis.length;i++){
            if(vis[i] == false)return false;
        }
        return true;
    }
    public void dfs(List<List<Integer>> rooms,int x){
        vis[x] = true;
        List<Integer> list = rooms.get(x);
        for(int next:list){
            if(!vis[next]){
                dfs(rooms,next);
            }
        }
    }
}
