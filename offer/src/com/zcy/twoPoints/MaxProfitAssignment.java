package com.zcy.twoPoints;

import java.util.Arrays;

public class MaxProfitAssignment {
    //自写，超内存？？？
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        //要排序
        //声明一个二维数组，把diff和profit聚合起来排序
        int n = difficulty.length;
        int[][] arr = new int[n][n];
        for(int i = 0;i < n;i++){
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr,(o1, o2)->(o2[1]-o1[1] != 0?o2[1] - o1[1]:o1[0] - o2[0]));
        //利益从大到小排，如果利益相等，将难度从小到大排
        Arrays.sort(worker);
        int j = 0;
        int res = 0;
        for(int i = worker.length - 1;i>=0;i--){
            while(j<n&&worker[i]<arr[j][0]){
                j++;
            }
            if(j == n)break;
            res+=arr[j][1];
        }
        return res;
    }
    //*******************下面的不爆内存
    public int maxProfitAssignment6(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length, m = worker.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] { difficulty[i], profit[i] };
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);//按难度从小到大排
        Arrays.sort(worker);
        int ans = 0, maxProfit = 0;
        //记录遍历到的最大收益，后面的worker收益一定不比这更低
        for (int i = 0, j = 0; i < m; i++) {
            int ability = worker[i];
            while (j < n && jobs[j][0] <= ability) {
                maxProfit = Math.max(maxProfit, jobs[j][1]);
                j++;
            }
            ans += maxProfit;
        }
        return ans;
    }
}
