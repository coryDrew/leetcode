package com.zcy.backtrack;

import java.util.Arrays;

public class MakeSquare473 {
    //想不到，时间复杂度o(4的n次方)
    //dp是更好的解法
    public boolean makesquare(int[] matchsticks) {
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {//首先判断能否被4整除
            return false;
        }
        Arrays.sort(matchsticks);//不好用lambda，因为是int而并不是integer
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }//倒序排列

        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, totalLen / 4);
    }

    public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            //遍历到最后了，说明所有的火柴都插入了，直接返回成功
            //因为前面已经确定能被4整除，而且又要求每条边不能大于len，所以可以保证在所有火柴都被允许插入的情况下，插到最后必然是四条边相等的情况。
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
