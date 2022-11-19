package com.zcy.offertwo;

public class OfferTwo026 {
    public void reorderList(ListNode head) {
        ListNode l1 = head;
        ListNode lastForl1 = findMid(head);
        ListNode l2 = lastForl1.next;
        lastForl1.next = null;
        l2 = reverse(l2);
        combine(l1,l2);
    }
    public ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null&&fast.next.next != null){//中点前一个这个找的是，因为要把这个点的next置null
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode next = null;
        ListNode pre = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public void combine(ListNode h1,ListNode h2){//用两个新节点存储下一个位置节点，另外，由于要求原地修改，所以不能新建头结点
        ListNode cur1;
        ListNode cur2;

        while(h1 != null&&h2 != null){
            cur1 = h1.next;
            cur2 = h2.next;
            h1.next = h2;
            h2.next = cur1;
            h1 = cur1;
            h2 = cur2;
        }
    }
}
