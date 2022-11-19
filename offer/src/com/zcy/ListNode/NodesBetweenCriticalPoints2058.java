package com.zcy.ListNode;

import com.zcy.usualClass.ListNode;

import java.util.ArrayList;
import java.util.List;

public class NodesBetweenCriticalPoints2058 {
    //弱智题
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        int index = 0;
        int pre = -1;
        while(cur!=null && cur.next != null){
            if(cur == head){
                pre = cur.val;
            }else{
                if(cur.val < pre &&cur.val < cur.next.val
                        ||cur.val > pre &&cur.val > cur.next.val){
                    list.add(index);
                }
                pre = cur.val;
            }
            cur = cur.next;
            index++;
        }
        int[] res = new int[2];
        if(list.size() == 0 || list.size() == 1){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int min = 100001;
        for(int i = 1;i < list.size();i++){
            int tmp = list.get(i) - list.get(i-1);
            if(tmp < min){
                min = tmp;
            }
        }
        res[0] = min;
        res[1] = list.get(list.size() - 1) - list.get(0);
        return res;

    }
}
