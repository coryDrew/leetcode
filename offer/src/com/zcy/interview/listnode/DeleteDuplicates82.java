package com.zcy.interview.listnode;

public class DeleteDuplicates82 {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        ListNode cur = head;
        while(cur != null){
            map.put(cur.val,map.getOrDefault(cur.val,0)+1);
            cur = cur.next;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        cur = dummyHead;
        while(cur != null && cur.next != null){
            if(map.get(cur.next.val) > 1){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
