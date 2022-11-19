package com.zcy.hash;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs447 {
    public int numberOfBoomerangs(int[][] points) {
        //一个点一个哈希表,比较浪费空间，但是要有这种思路，脑子灵活点啊你
        int res = 0;
        for(int[] p: points){
            Map<Integer,Integer> map = new HashMap<>();
            for(int[] q: points){
                int dis = (p[0] - q[0])*(p[0] - q[0])+(p[1] - q[1])*(p[1] - q[1]);
                map.put(dis,map.getOrDefault(dis,0) + 1);
            }
            for(int i:map.values()){

                res+=i*(i - 1);
            }
        }
        return res;
    }
}
