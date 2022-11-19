package com.zcy.DFS;

public class CanReach1306 {
    自写dfs
    boolean[] vis;
    public boolean canReach(int[] arr, int start) {
        vis = new boolean[arr.length];
        return dfs(arr,start);
    }
    public boolean dfs(int[] arr,int start){
        if(arr[start] == 0)return true;
        vis[start] = true;
        int back = start - arr[start];
        int forward = start + arr[start];
        if(back >= 0 &&!vis[back] &&  dfs(arr,back)) return true;
        if(forward< arr.length && !vis[forward] &&dfs(arr,forward)) return true;
        return false;
    }
}
