package com.zcy.DFS;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes802 {
    //dfs+记忆化搜索
    boolean[] visited; // 记录访问过的节点
    boolean[] OK; // 记录该节点是否是安全节点--默认false

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> list = new ArrayList<>(); // 存储结果
        visited = new boolean[n];
        OK = new boolean[n];

        // 第一个for循环是找到终端节点
        for (int i = 0; i < n; i++) {
            if(graph[i].length == 0){
                visited[i] = true;
                OK[i] = true;
            }
        }

        // 第二个for循环是遍历所有节点，并且用DFS+记忆化搜索来判断是否是安全节点
        for (int i = 0; i < n; i++) {
            if(DFS(graph, i)){
                list.add(i);
            }
        }
        return list;
    }
    public boolean DFS(int[][] graph, int start){//start如果是安全节点，则返回true
        // 如果被拜访过 直接返回该节点是否是安全节点
        if(visited[start]){//直接返回提升效率
            return OK[start];
        }
        // 进来就标记，这是因为可能存在环，如果我们进来就标记了，后面出现重复遍历的时候，因为我们是用DFS，所以我们就知道该节点是在一个环路中的
        visited[start] = true;
        for (int i : graph[start]) {
            // 判断是否有一条路径不能到达终端节点，只要有一条不满足就直接返回，并且把该节点标记为false
            if(!DFS(graph, i)){//子问题，若start的某一个边的节点i是安全节点（所有路径都到终端节点），那start经过i也是全部到达终端节点
                //若start的所有相邻节点都是安全节点，那start也是一个安全节点！！！
                OK[start] = false;
                return false;
            }
        }
        OK[start] = true;
        return true;
    }
}
