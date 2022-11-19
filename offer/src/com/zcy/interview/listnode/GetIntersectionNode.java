package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

import java.util.HashSet;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != null){
            set.add(curA);
            curA = curA.next;
        }
        while(curB != null){
            if(set.contains(curB))return curB;
            curB = curB.next;
        }
        return null;
    }
}
