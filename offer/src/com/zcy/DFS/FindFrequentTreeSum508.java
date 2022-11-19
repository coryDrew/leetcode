package com.zcy.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindFrequentTreeSum508 {
    //dfs有模板吗？
    int max = 0;
    Map<Integer,Integer> map = new HashMap<>();//key为子树和，value为出现次数
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int s = entry.getKey(),c =entry.getValue();
            if(c == max) list.add(s);
        }
        int[] ans = new int[list.size()];
        for(int i = 0;i < list.size();i++) ans[i] = list.get(i);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int sum = root.val + dfs(root.left) + dfs(root.right);
        map.put(sum,map.getOrDefault(sum,0) + 1);
        max = Math.max(max,map.get(sum));
        return sum;
    }
}
