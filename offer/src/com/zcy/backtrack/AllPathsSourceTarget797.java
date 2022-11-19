package com.zcy.backtrack;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget797 {
    //回溯越来越简单
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res = new ArrayList<>();
        n = graph.length;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        backtrack(graph,list,0);
        return res;
    }
    private void backtrack(int[][] graph,List<Integer> list,int node){
        if(node == n - 1){
            res.add(new ArrayList(list));
            return;
        }

        int[] edge = graph[node];
        for(int i = 0;i < edge.length;i++){
            list.add(edge[i]);
            backtrack(graph,list,edge[i]);
            list.remove(list.size() - 1);
        }
    }
}
