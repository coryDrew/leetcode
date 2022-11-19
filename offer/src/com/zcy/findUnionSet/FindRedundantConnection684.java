package com.zcy.findUnionSet;

public class FindRedundantConnection684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];//节点是1~n
        for(int i = 0;i <= n;i++){
            parent[i] = i;
        }
        for(int i = 0;i < n;i++){
            int[] edge = edges[i];
            int node1 = edge[0],node2 = edge[1];
            if(find(parent,node1) != find(parent,node2)){
                union(parent,node1,node2);
            }else{
                return edge;//这里返回的必然是最后一个，因为只有最后一个才能让图最终形成环
            }
        }
        return new int[0];
    }
    private void union(int[] parent,int index1,int index2){
        parent[find(parent,index1)] = find(parent,index2);
    }
    private int find(int[] parent,int index){
        if(parent[index] != index){
            parent[index] = find(parent,parent[index]);
        }
        return parent[index];
    }
}
