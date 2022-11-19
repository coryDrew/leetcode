package com.zcy.sort;

import java.util.Arrays;

public class TwoCitySchedCost1029 {
    ///想不出来啊
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(o1, o2)->o1[0] - o1[1] -(o2[0] - o2[1]));
        int res = 0;
        for(int i = 0;i < costs.length;i++){
            if(i<costs.length / 2){
                res+=costs[i][0];
            }else{
                res+=costs[i][1];
            }
        }
        return res;
    }
}
