package com.zcy.tree;

import java.util.ArrayList;
import java.util.List;

public class CountHighestScoreNodes2049 {
    long maxScore = 0;
    int count = 0;
    int n;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
        dfs(0);
        return count;
    }

    public int dfs(int node) {//返回值是当前节点的大小（即以当前节点为头的子树的节点个数）
        long score = 1;
        int sum = 1;
        for (int num : children[node]) {
            int t = dfs(num);
            score *= t;
            sum += t;
        }
        if (node != 0) {//非根节点，有三段要乘起来
            score *= n - sum;
        }
        if (maxScore == score) {
            count++;
        } else if (maxScore < score) {
            maxScore = score;
            count = 1;
        }
        return sum;
    }

}
