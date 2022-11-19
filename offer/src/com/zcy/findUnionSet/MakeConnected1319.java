package com.zcy.findUnionSet;

public class MakeConnected1319 {
    /**
     我们如何保证一定能找出「一条」多余的边呢？我们需要证明的是，在任意时刻，如果图中有 k'k
     ′
     个连通分量且 k'>1k
     ′
     >1，即整个图还没有完全连通，那么一定存在一个连通分量，使得其有一条多余的边：即它的节点数为 m_im
     i
     ​
     ，边数为 e_ie
     i
     ​
     ，并且有 e_i > m_i - 1e
     i
     ​
     >m
     i
     ​
     −1。

     */
    int[] parent;
    public int makeConnected(int n, int[][] connections) {
        //有i组，就需要i - 1根线？
        if(connections.length<n - 1){
            return -1;
        }
        parent = new int[n];
        for(int i = 0;i < parent.length;i++){
            parent[i] = i;
        }
        int cnt = 0;
        for(int i = 0;i < connections.length;i++){
            if(find(connections[i][0])!=find(connections[i][1])){
                union(connections[i][0],connections[i][1]);
            }
        }
        int len = connections.length;//边的数量
        for(int i = 0;i < n;i++){
            if(parent[i] == i) cnt++;
        }
        return cnt - 1;//证明出的结论！
    }
    public void union(int x,int y){
        parent[parent[x]] = parent[y];
    }
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
