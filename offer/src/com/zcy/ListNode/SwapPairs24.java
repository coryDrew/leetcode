package com.zcy.ListNode;


import com.zcy.usualClass.ListNode;

public class SwapPairs24 {
    //dummyHead可以保持代码一致性！什么意思呢，就是能让每一次的过程都完全一致，即cur后面的两个节点进行交换
    //总之，感到别扭，就用dummyHead试试
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while(cur.next!= null&&cur.next.next != null){
            ListNode n1 = cur.next;
            ListNode n2 = cur.next.next;
            cur.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            cur = n1;
        }
        return dummyHead.next;
    }
}
