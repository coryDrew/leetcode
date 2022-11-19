package com.zcy.topology;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindOrder210 {
    /**
     先说最重要的部分：
     「拓扑排序」是专门应用于有向图的算法；
     这道题用 BFS 和 DFS 都可以完成，只需要掌握 BFS 的写法就可以了，BFS 的写法很经典；
     BFS 的写法就叫「拓扑排序」，这里还用到了贪心算法的思想，贪的点是：当前让入度为 0 的那些结点入队；
     「拓扑排序」的结果不唯一；
     删除结点的操作，通过「入度数组」体现，这个技巧要掌握；
     「拓扑排序」的一个附加效果是：能够顺带检测有向图中是否存在环，这个知识点非常重要，如果在面试的过程中遇到这个问题，要把这一点说出来。
     */
    //必须要记住这些结构，写拓扑（bfs）时才有思路！！！！！！！！！！！！
    // 存储有向图
    List<List<Integer>> edges;
    // 存储每个节点的入度
    int[] indeg;
    // 存储答案
    int[] result;
    // 答案下标
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        for (int[] info : prerequisites) {//这个for循环，就比较优雅，多学习好的代码习惯
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        // 将所有入度为 0 的节点放入队列中
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 从队首取出一个节点
            int u = queue.poll();
            // 放入答案中
            result[index++] = u;
            for (int v: edges.get(u)) {
                --indeg[v];
                // 如果相邻节点 v 的入度为 0，就可以选 v 对应的课程了
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}
