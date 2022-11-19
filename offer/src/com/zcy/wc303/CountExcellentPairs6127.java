package com.zcy.wc303;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountExcellentPairs6127 {
    //bitcount方法  算1的个数
    //脑筋急转弯  记 c(x)c(x) 为 xx 的二进制表示中的 11 的个数，则有如下等式：
    //c(x∣y)+c(x&y)=c(x)+c(y)
    public long countExcellentPairs(int[] nums, int k) {
        long ans = 0L;
        Set<Integer> vis = new HashSet<Integer>();
        Map<Integer,Integer> cnt = new HashMap<Integer, Integer>();
        for (int x : nums)
            if (!vis.contains(x)) {
                vis.add(x);
                int c = Integer.bitCount(x);
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            }
        for (Map.Entry<Integer,Integer> x : cnt.entrySet())
            for (Map.Entry<Integer,Integer> y : cnt.entrySet())
                if (x.getKey() + y.getKey() >= k)
                    ans += (long) x.getValue() * y.getValue();
        return ans;
    }
}
