package com.zcy.ListNode;

import com.zcy.usualClass.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class addTwoNumbers445 {
    //💪💪对于逆序处理应该首先想到栈，对吧？😎
    //下为自写
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2= new LinkedList<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1!=null){
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }
        while(cur2!=null){
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }
        ListNode cur = null;
        int carry = 0;
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            int a = !stack1.isEmpty()?stack1.pop() :0;
            int b = !stack2.isEmpty()?stack2.pop() :0;
            int sum = a+b+carry;
            int num = sum%10;
            carry = sum/10;
            ListNode tmp = new ListNode(num);
            tmp.next = cur;//和答案一样，这两步，很关键
            cur = tmp;
        }
        if(carry != 0){
            ListNode head = new ListNode(carry);
            head.next = cur;
            return head;
        }
        return cur;
    }
}
