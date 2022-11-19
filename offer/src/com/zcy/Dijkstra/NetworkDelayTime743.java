package com.zcy.Dijkstra;

import java.util.Arrays;

public class NetworkDelayTime743 {
    //迪杰斯特拉，不咋会
    private int INF = 0x3f3f3f3f;

    public int networkDelayTime(int[][] times, int n, int k) {
        // 朴素 Dijkstra
        int[][] g = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(g[i], INF);
        }

        for (int[] time : times) {
            g[time[0]][time[1]] = time[2];
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        dist[k] = 0;

        dijkstra(g, dist, n, k);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }

        return ans >= INF ? -1 : ans;
    }

    private void dijkstra(int[][] g, int[] dist, int n, int k) {
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            int x = -1;
            for (int j = 1; j <= n; j++) {//还没visit里的点中离源点最近的点
                if (!visited[j] && (x == -1 || dist[j] < dist[x])) {
                    x = j;
                }
            }

            visited[x] = true;

            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[x] + g[x][j]);
            }
        }
    }
}
