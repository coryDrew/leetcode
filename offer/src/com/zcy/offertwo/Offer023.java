package com.zcy.offertwo;

import java.util.HashSet;
import java.util.Set;

public class Offer023 {
    //自写太慢了，击败11
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode curA = headA;
        while(curA != null){
            set.add(curA);
            curA = curA.next;
        }
        ListNode curB = headB;
        while(curB != null){
            if(set.contains(curB)){
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }
    //双指针 击败97
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
