package com.zcy.ListNode;

import com.zcy.usualClass.ListNode;

import java.util.HashSet;
import java.util.Set;

public class NumComponents817 {
    //简单题
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for(int i = 0;i < len;i++){
            set.add(nums[i]);
        }
        ListNode cur = head;
        boolean flag = false;
        int res = 0;
        while(cur != null){
            if(set.contains(cur.val)){
                if(flag == false){//连着出现集合里的值，只有第一次会加res
                    flag = true;
                    res++;
                }
            }else{
                flag = false;//不在集合里，重置flag
            }
            cur = cur.next;
        }
        return res;
    }
}
