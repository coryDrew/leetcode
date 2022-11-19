package com.zcy.offertwo.important;

import com.zcy.usualClass.ListNode;

public class Offer078 {
    //与77比较，
    //最终形态是获得两个'一半'的链表，最终将这两个‘一半’的链表合并成一个总的链表
    //需要两个函数，一个是递归的合并函数(我称为混子函数)，还有一个是合并两个链表的函数
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length - 1);
    }
    public ListNode merge(ListNode[] lists,int l,int r){
        //该函数的作用是将从l到r所有的链表合并，并返回合并之后的头结点
        if(l == r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid = ((r - l)>>1)+l;
        //最左到中间的链表合并之后形成的大链表与中间到最右合并之后形成的大链表最终再进行两个链表之间的合并
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    public ListNode mergeTwoLists(ListNode a, ListNode b){
        //只新建两个节点，坏处是让ab改变了指向的节点对象
        ListNode head = new ListNode();
        ListNode cur = head;
        while(a != null && b != null){
            if(a.val < b.val){
                cur.next = a;
                a = a.next;
            }else{
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if(a != null){
            cur.next = a;
        }
        if(b != null){
            cur.next = b;
        }
        return head.next;
    }
}
