package com.zcy.wc304;

import java.util.LinkedList;

public class LongestCycle6135 {
    //hard，tanjar算法求强联通分量
    int[] v = null;
    int[] e = null;
    int[] dfn = null;
    int[] low = null;
    int index = 0;
    int ret = 0;
    LinkedList<Integer> list = new LinkedList<>();

    public int longestCycle(int[] edges) {
        int len = edges.length;
        v = new int[len];
        e = edges;
        dfn = new int[len];
        low = new int[len];
        for (int i = 0; i < len; i++) {
            if (v[i] == 0) {
                tanjar(i);
            }
        }
        return ret == 1? -1 : ret;
    }

    private void tanjar(int x) {
        dfn[x] = low[x] = ++index;
        list.addLast(x);
        v[x] = 1;
        if (e[x] != -1) {
            if (v[e[x]] == 0) {
                tanjar(e[x]);
                low[x] = Math.min(low[x], low[e[x]]);
            } else if (v[e[x]] == 1) {
                low[x] = Math.min(low[x], dfn[e[x]]);
            }
        }
        if (dfn[x] == low[x]) {
            int count = 1;
            int y = list.removeLast();
            v[y] = 2;
            while (y != x) {
                count++;
                y = list.removeLast();
                v[y] = 2;
            }
            ret = Math.max(ret, count);
        }
    }

    //时间戳，岭茶山爱抚
    public int longestCycle(int[] edges) {
        int n = edges.length, ans = -1;
        var time = new int[n];
        for (int i = 0, clock = 1; i < n; ++i) {
            if (time[i] > 0) continue;
            for (int x = i, start_time = clock; x >= 0; x = edges[x]) {
                if (time[x] > 0) { // 重复访问
                    if (time[x] >= start_time) // 找到了一个新的环
                        ans = Math.max(ans, clock - time[x]);
                    break;
                }
                time[x] = clock++;
            }
        }
        return ans;
    }

}
