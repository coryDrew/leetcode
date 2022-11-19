package com.zcy.priorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestPairs373 {
    boolean flag = true;
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //topK问题，都想优先队列
        //宫水三叶，这里讲的挺好的，画图能看出来，结论是对的
        int n = nums1.length, m = nums2.length;
        if (n > m && !(flag = false)) return kSmallestPairs(nums2, nums1, k);//让前面的是个数更少的，为了减少优先队列里的个数？提高效率
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->(nums1[a[0]]+nums2[a[1]])-(nums1[b[0]]+nums2[b[1]]));
        for (int i = 0; i < Math.min(n, k); i++) q.add(new int[]{i, 0});
        while (ans.size() < k && !q.isEmpty()) {
            int[] poll = q.poll();
            int a = poll[0], b = poll[1];
            ans.add(new ArrayList<>(){{
                add(flag ? nums1[a] : nums2[b]);
                add(flag ? nums2[b] : nums1[a]);
            }});
            if (b + 1 < m) q.add(new int[]{a, b + 1});
        }
        return ans;
    }
}
