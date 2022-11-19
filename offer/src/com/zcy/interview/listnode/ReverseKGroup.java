package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

public class ReverseKGroup {
    //先求长度，然后看要翻转几组
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
        ListNode tailPre = dummyHead;//dummyhead充当首次迭代时尾的前一个
        //保证每次循环后tail是下一轮翻转的尾，tailpre是尾的前一个
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
