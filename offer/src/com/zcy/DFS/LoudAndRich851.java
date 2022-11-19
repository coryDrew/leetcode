package com.zcy.DFS;

import java.util.*;

public class LoudAndRich851 {
    //自写暴搜超时
    Map<Integer, List<Integer>> map;
    int min;
    int minIndex;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        map = new HashMap<>();
        int[] res = new int[quiet.length];
        for(int[] rich:richer){
            if(map.get(rich[1]) == null){
                map.put(rich[1],new ArrayList<>());
            }
            map.get(rich[1]).add(rich[0]);
        }
        for(int i = 0;i < quiet.length;i++){
            min = quiet[i];
            minIndex = i;
            dfs(i,quiet);
            res[i] = minIndex;
        }
        return res;
    }
    public void dfs(int x,int[] quiet){
        List<Integer> list = map.get(x);
        if(list != null){
            for(int i :list){
                if(min > quiet[i]){
                    min = quiet[i];
                    minIndex = i;
                }
                dfs(i,quiet);
            }
        }
    }
    //记忆化搜索
    int ans[];
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> richerOnes=new ArrayList<>();//记录比每个人更有钱的人
        for(int i=0;i<quiet.length;i++){richerOnes.add(new ArrayList<>());}
        for(int i=0;i<richer.length;i++){richerOnes.get(richer[i][1]).add(richer[i][0]);}
        ans=new int[quiet.length];
        for(int i=0;i<quiet.length;i++){ans[i]--;}
        for(int i=0;i<quiet.length;i++){findLAR(richerOnes,quiet,i);}
        return ans;
    }
    public void findLAR(List<List<Integer>> richerOnes,int quiet[],int k){
        //找到比k更有钱的人里面最安静的那个
        if(ans[k]>=0){return;}
        ans[k]=k;
        for(int i=0;i<richerOnes.get(k).size();i++){
            int p=richerOnes.get(k).get(i);
            findLAR(richerOnes,quiet,p);
            if(quiet[ans[k]]>quiet[ans[p]]){ans[k]=ans[p];}
        }
    }
    //拓扑
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        int[] inDeg = new int[n];
        for (int[] r : richer) {
            g[r[0]].add(r[1]);
            ++inDeg[r[1]];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = i;
        }
        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            if (inDeg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int y : g[x]) {
                if (quiet[ans[x]] < quiet[ans[y]]) {
                    ans[y] = ans[x]; // 更新 x 的邻居的答案
                }
                if (--inDeg[y] == 0) {
                    q.offer(y);
                }
            }
        }
        return ans;
    }


}
