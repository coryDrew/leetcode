package com.zcy.BFS;

import java.util.*;

public class FindMinHeightTrees310 {
    //我真的佛了
    /**我们只需要求出路径最长的两个叶子节点即可，并求出其路径的最中间的节点即为最小高度树的根节点。可以利用以下算法找到图中距离最远的两个节点与它们之间的路径：

     以任意节点 pp 出现，利用广度优先搜索或者深度优先搜索找到以 pp 为起点的最长路径的终点 xx；

     以节点 xx 出发，找到以 xx 为起点的最长路径的终点 yy；

     xx 到 yy 之间的路径即为图中的最长路径，找到路径的中间节点即为根节点。

     作者：LeetCode-Solution
     链接：https://leetcode.cn/problems/minimum-height-trees/solution/zui-xiao-gao-du-shu-by-leetcode-solution-6v6f/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<Integer>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        /* 找到与节点 0 最远的节点 x */
        int x = findLongestNode(0, parent, adj);
        /* 找到与节点 x 最远的节点 y */
        int y = findLongestNode(x, parent, adj);
        /* 求出节点 x 到节点 y 的路径 */
        List<Integer> path = new ArrayList<Integer>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            ans.add(path.get(m / 2 - 1));
        }
        ans.add(path.get(m / 2));
        return ans;
    }

    public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visit = new boolean[n];
        queue.offer(u);
        visit[u] = true;
        int node = -1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            node = curr;
            for (int v : adj[curr]) {
                if (!visit[v]) {
                    visit[v] = true;
                    parent[v] = curr;
                    queue.offer(v);
                }
            }
        }
        return node;
    }
}
