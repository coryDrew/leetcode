package com.zcy.DFS;

import java.util.List;

public class NumOfMinutes1376 {
    Map<Integer, List<Integer>> map;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        map = new HashMap<>();
        for(int i = 0;i < manager.length;i++){
            if(!map.containsKey(manager[i])){
                map.put(manager[i],new ArrayList<>());
            }
            map.get(manager[i]).add(i);
        }
        return minutes(headID,manager,informTime);
    }
    public int minutes(int head,int[] manager,int[] informTime){
        if (informTime[head] == 0) {
            // 当前员工无下属，那么花费时间为0
            return 0;
        }
        int headTime = informTime[head];
        int maxTime = 0;
        List<Integer> list = map.get(head);
        for(int i = 0;i < list.size();i++){

            int time = minutes(list.get(i),manager,informTime);
            maxTime = Math.max(maxTime,time);

        }
        return headTime+ maxTime;
    }
}
