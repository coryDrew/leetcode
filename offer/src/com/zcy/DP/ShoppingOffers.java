package com.zcy.DP;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers{
    //记忆化搜索，简单易懂！！
    Map<List<Integer>,Integer> cache = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(needs, price, special);
    }
    //dfs就是求needs商品最少多少钱！
    public int dfs(List<Integer> needs, List<Integer> price, List<List<Integer>> special) {
        if (cache.containsKey(needs))
            return cache.get(needs);
        int ans = 0;
        for (int i = 0; i < needs.size(); i++) {
            ans += needs.get(i) * price.get(i);
        }
        for (int i = 0; i < special.size(); i++) {
            List<Integer> next = new ArrayList<>(needs);
            boolean flag = true;
            for (int item = 0; item < price.size(); item++) {
                if (special.get(i).get(item) > needs.get(item)) {
                    flag = false;
                    break;
                }
            }

            if (!flag) continue;
            for (int item = 0; item < price.size(); item++) {
                next.set(item, next.get(item) - special.get(i).get(item));
            }
            //拆成子问题！！！，买了一个大礼包后，剩下需要的钱+这个大礼包的钱，取所有中的最小！！！！
            ans = Math.min(ans, dfs(next, price, special) + special.get(i).get(price.size()));
        }
        cache.put(needs, ans);
        return ans;
    }

}
