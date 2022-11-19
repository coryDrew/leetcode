package com.zcy.findUnionSet;

public class RemoveStones947 {
    //简单并查集
    //自写
    int[] parent;
    public int removeStones(int[][] stones) {
        parent = new int[stones.length];
        for(int i = 0;i < stones.length;i++){
            parent[i] = i;
        }
        for(int i = 0;i < stones.length;i++){
            for(int j = i+1;j < stones.length;j++){
                if(stones[i][0] == stones[j][0]||stones[i][1] == stones[j][1]){
                    if(find(i) != find(j)){
                        union(i,j);
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0;i < stones.length;i++){
            if(parent[i] == i){
                res++;
            }
        }
        return stones.length - res;
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
