package com.zcy.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction786 {
    //compare只能返回int类型
    //自写六百毫秒
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if((double)o1[0]/o1[1] - (double)o2[0]/o2[1]>0){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = i+1;j < arr.length;j++){
                pq.offer(new int[]{arr[i],arr[j]});
            }
        }
        int[] res = new int[2];
        for(int i = 0;i < k;i++){
            res = pq.poll();
        }
        return res;
    }
    //官解
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x, y) -> arr[x[0]] * arr[y[1]] - arr[y[0]] * arr[x[1]]);
        for (int j = 1; j < n; ++j) {
            pq.offer(new int[]{0, j});
        }
        for (int i = 1; i < k; ++i) {
            int[] frac = pq.poll();
            int x = frac[0], y = frac[1];
            if (x + 1 < y) {
                pq.offer(new int[]{x + 1, y});
            }
        }
        return new int[]{arr[pq.peek()[0]], arr[pq.peek()[1]]};
    }


}
