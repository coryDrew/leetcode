package com.zcy.offertwo;

import java.util.Deque;
import java.util.LinkedList;

public class Offer025 {
    //倒过来的东西要想到栈！！！，没有这种思维
    //这里构造链表用头插法，不会写！
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        while(l1!= null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!= null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null,tail = null;
        int carry = 0;
        ListNode ans = null;//这里是头插法，基础差写不出来
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }
}
