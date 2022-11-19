package com.zcy.wc304;

public class MaximumGroups6133 {
    //简单数学题，写的不好理解
    public int maximumGroups(int[] grades) {
        if(grades.length == 1||grades.length == 2){
            return 1;
        }
        int sum = 0;
        int add = 1;
        int group = 1;
        int len = grades.length;
        while(sum < len){
            sum += add;
            if(sum <= len){
                group++;
                add++;
            }
        }

        return add - 1;
    }
}
