package com.zcy.inputExe;

import java.util.Scanner;

public class LinkListInput {
    //反转链表举例
    static class LinkNode{//正常情况下静态类不能实例化，但这是静态内部类，可以实例化！！
        int val;
        LinkNode next;
        public LinkNode(){}
        public LinkNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args){
        //输入为1,2,3,4,5的形式，以逗号隔开，可以直接用next接收所有（因为没有空格）
        Scanner sc = new Scanner(System.in);
        String str = sc.next();//默认接收为字符串，只有调用nextInt才会识别成数字？感觉是这样
        String[] arr = str.split(",");
        int[] num = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            num[i] = Integer.valueOf(arr[i]);
        }
        LinkNode head = new LinkNode(0);
        LinkNode p = head;
        for(int i = 0;i < num.length;i++){
            p.next = new LinkNode(num[i]);
            p = p.next;
        }
        LinkNode res =  reverse(head.next);
        while(res != null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
    public static LinkNode reverse(LinkNode head){
        LinkNode cur = head;
        LinkNode pre = null;
        LinkNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
