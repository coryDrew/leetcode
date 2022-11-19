package com.zcy.ListNode;

import com.zcy.usualClass.ListNode;

public class ReverseKGroup25 {
    //自写，其实算不上hard题吧
    //dummyhead的存在保证了循环时操作的一致性！
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        int cnt = 0;
        while(tmp != null){
            cnt++;
            tmp = tmp.next;
        }
        int group = cnt/k;
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode tail = head;
        ListNode tailPre = dummyHead;
        for(int i = 0;i < group;i++){
            ListNode cur = tail;
            ListNode pre = null;
            ListNode next = null;
            for(int j = 0;j < k;j++){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            //最终pre是翻转后的头，tail是翻转后的尾，要和上一组的尾和下一组的头相接一下。
            tailPre.next = pre;
            tail.next = cur;
            tailPre = tail;
            tail = tail.next;

        }
        return dummyHead.next;
    }
}
