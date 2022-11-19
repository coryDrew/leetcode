package com.zcy.offertwo;

import java.util.List;

public class Offer061 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((o1,o2)->(o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1)));
        for(int i = 0;i < nums1.length;i++){
            List<Integer> list =  new ArrayList<>();
            list.add(nums1[i]);
            for(int j = 0;j < nums2.length;j++){
                list.add(nums2[j]);
                pq.add(new ArrayList<>(list));
                list.remove(1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while(k-->0&&!pq.isEmpty()){
            res.add(pq.poll());

        }
        return res;
    }
}
