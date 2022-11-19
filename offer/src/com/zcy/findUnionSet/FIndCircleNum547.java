package com.zcy.findUnionSet;

import java.util.HashMap;
import java.util.Map;

public class FIndCircleNum547 {
    public int findCircleNum(int[][] isConnected) {
        //判断一共有多少个集合即可，有多少个大爹
        UnionFind1 uf = new UnionFind();
        for(int i = 0;i < isConnected.length;i++){
            for(int j = 0;j < isConnected[0].length;j++){
                if(!uf.parent.containsKey(i)){
                    uf.parent.put(i,i);
                }
                if(!uf.parent.containsKey(j)){
                    uf.parent.put(j,j);
                }
                if(isConnected[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        int res = 0;
        for(int i = 0;i < isConnected.length;i++){
            if(uf.find(i) == i){
                res++;
            }
        }
        return res;
    }
}
class UnionFind1{
    Map<Integer,Integer> parent;
    public UnionFind(){
        parent = new HashMap<>();
    }
    public int find(int x){//x号城市的爹
        if(parent.get(x) == x){
            return x;
        }
        parent.put(x,find(parent.get(x)));
        return parent.get(x);
    }
    public void union(int x,int y){
        int p1 = find(x);
        int p2 = find(y);
        if(p1 == p2){
            return;
        }
        parent.put(p1,p2);
    }
}
