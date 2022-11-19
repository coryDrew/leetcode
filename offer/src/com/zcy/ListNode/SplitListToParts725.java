package com.zcy.ListNode;

import com.zcy.usualClass.ListNode;

public class SplitListToParts725 {
    /**
     1，遍历链表获取长度 length（这个跑不掉 😓）；悲哀
     2，length 除以 k 得到每段链表的平均长度 aveLength 和 余数 remainder，remainder 的值就是有多少个长度为 (aveLength + 1) 的子链表排在前面。
     2.1，举个例子帮助理解一下 11 / 3 = 3 余 2： 一共有3段，每段平均3个节点，但是剩下了2个节点，剩下的2个节点不能丢啊，得全部塞到子链表里面去，怎么塞呢？
     2.2，根据题意长的链表排前面，短的链表排后面，所以只有前面的两个子链表一人分担一个多余的节点，如此一来便形成了 4 4 3 的结构。
     3，接下来的事儿就比较简单了，按照每个子链表应该的长度[4, 4, 3]去截断给定的链表。
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int quotient = n / k, remainder = n % k;

        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }
}
