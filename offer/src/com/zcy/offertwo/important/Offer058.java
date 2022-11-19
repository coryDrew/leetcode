package com.zcy.offertwo.important;

import java.util.Map;
import java.util.TreeMap;

public class Offer058 {
    //TreeMap底层是根据红黑树的数据结构构建的，默认是根据key的自然排序来组织
    TreeMap<Integer,Integer> treeMap;
    public MyCalendar() {
        treeMap = new TreeMap<>();

    }

    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> ceilingEntry = treeMap.ceilingEntry(start);
        Map.Entry<Integer,Integer> floorEntry = treeMap.floorEntry(start);
        if((ceilingEntry == null || end<=ceilingEntry.getKey())
                &&(floorEntry == null || floorEntry.getValue()<=start)
        ){
            treeMap.put(start,end);
            return true;
        }
        return false;

    }
}
