package com.zcy.weeklyCompetition301;

import java.util.TreeSet;

public class SmallestInfiniteSet6113 {
    //自写，假的无限集
    TreeSet<Integer> set;
    public SmallestInfiniteSet6113() {
        set = new TreeSet<>();
        for(int i = 1;i <= 1000;i++){
            set.add(i);
        }
    }

    public int popSmallest() {

        return set.pollFirst();
    }

    public void addBack(int num) {
        if(set.contains(num)){
            return;
        }
        set.add(num);
    }
}
