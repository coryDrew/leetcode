package com.zcy.wc305;

import java.util.*;

public class reachableNodes6139 {
    //自写通过，100ms
    Set<Integer> set = new HashSet<>();

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] vis = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> rest = new HashSet<>();
        for(int i = 0;i < restricted.length;i++){
            rest.add(restricted[i]);
        }
        for(int i = 0;i < edges.length;i++){
            if(!rest.contains(edges[i][0])&&!rest.contains(edges[i][1])){
                if(!map.containsKey(edges[i][0])){
                    map.put(edges[i][0],new ArrayList<>());
                }
                if(!map.containsKey(edges[i][1])){
                    map.put(edges[i][1],new ArrayList<>());
                }
                map.get(edges[i][0]).add(edges[i][1]);
                map.get(edges[i][1]).add(edges[i][0]);
            }

        }
        dfs(0,map,vis);
        return set.size() + 1;
    }
    private void dfs(int x,Map<Integer,List<Integer>>map,boolean[] vis){
        List<Integer> list = map.get(x);
        if(list == null){
            return;
        }
        vis[x] = true;
        for(int i = 0;i < list.size();i++){
            if(!vis[list.get(i)]){
                set.add(list.get(i));
                dfs(list.get(i),map,vis);
            }
        }
    }
    //更快的方法
    public int reachableNodes666(int n, int[][] edges, int[] restricted) {
        List<Integer>[] adj = new List[n];//集合数组牛逼啦
        for (int i = 0; i < n; ++i){
            adj[i] = new ArrayList<>();
        }
        // 邻接表建图
        for (int i = 0; i < n - 1; ++i){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        boolean[] vis = new boolean[n];
        // 处理restricted数组
        for (int num : restricted) vis[num] = true;
        Deque<Integer> q = new LinkedList<>();
        q.addLast(0);
        vis[0] = true;
        int ans = 1;
        while (!q.isEmpty()){
            int cur = q.pollFirst();
            for (int next : adj[cur]){
                if (!vis[next]){
                    q.addLast(next);
                    vis[next] = true;
                    ++ans;
                }
            }
        }
        return ans;
    }
}
