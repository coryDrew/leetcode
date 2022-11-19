package com.zcy.DP;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement397 {
    //法一：递归
    public int integerReplacement(int n) {
        if(n == 1){
            return 0;
        }
        if(n % 2 == 0){
            return integerReplacement(n/2) + 1;
        }else{
            return Math.min(integerReplacement(n/2 + 1),integerReplacement(n/2))+2;
        }
    }
    //法二：记忆化搜索
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int integerReplacement1(int n) {
        if (n == 1) {
            return 0;
        }
        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, 1 + integerReplacement(n / 2));
            } else {
                memo.put(n, 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)));
            }
        }
        return memo.get(n);
    }
}
