package com.zcy.findUnionSet;

public class MaximumSegmentSum6159 {
    //逆向思维+并查集
    //hard
    int[] parent;
    long[] sum;

    int find(int x){
        if(x != parent[x]){
            x = find(parent[x]);
        }
        return x;
    }

    void union(int a, int b){
        sum[find(b)] += sum[find(a)];//最大子段的扩张，最终根据总爹就能找到最新的最大子段
        parent[find(a)] = find(b);//换爹
    }

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries){
        int n = nums.length;
        parent = new int[n];
        sum = new long[n];
        boolean[] vis = new boolean[n];
        long[] ans = new long[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            sum[i] = nums[i];
        }
        long cur = 0;
        for(int i = n - 1; i > 0; i--){
            int r = removeQueries[i];
            vis[r] = true;//代表这个位置已经添加上去了，已经不是0了
            if(r > 0 && vis[r - 1]){//如果r -1 位置不是0
                union(r - 1, r);
            }
            if(r < n - 1 && vis[r + 1]){//如果r + 1 位置不是0，继续合并
                union(r, r + 1);
            }
            cur = Math.max(cur, sum[find(r)]);
            ans[i - 1] = cur;
        }
        return ans;
    }
}
