package com.zcy.interview.listnode;

import com.zcy.usualClass.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeKLists23 {
    public static void main(String[] args) {


//         Scanner in = new Scanner(System.in);
//         int a = in.nextInt();
//         System.out.println(a);
//         System.out.println("Hello World!");
//        Scanner sc = new Scanner(System.in);
//        int k = sc.nextInt();
//        String[] s = new String[k];
//        List<String[]> list = new ArrayList<>();
//        for (int i = 0; i < k; i++) {
//            s[i] = sc.nextLine();
//            list.add(s[i].split(" "));
//        }
//        List<int[]> arrList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            int[] arr = new int[list.get(i).length];
//            for (int j = 0; j < arr.length; j++) {
//                arr[j] = Integer.valueOf(list.get(i)[j]);
//            }
//            arrList.add(arr);
//        }
//        ListNode[] nList = new ListNode[arrList.size()];
//        for (int i = 0; i < nList.length; i++) {
//            ListNode dummy = new ListNode();
//            ListNode cur = dummy;
//            for (int j = 0; j < arrList.get(i).length; j++) {
//                cur.next = new ListNode(arrList.get(i)[j]);
//                cur = cur.next;
//            }
//            nList[i] = dummy.next;
//        }
//        ListNode res = mergeKLists(nList);
//        ListNode tmp = res;
//        while (tmp != null) {
//            System.out.println(tmp.val);
//            tmp = tmp.next;
//        }
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String s1 = sc.nextLine();
        System.out.println(s);
        System.out.println(s1);
        String str = " 1 2 3";
        String[] str1 = str.split(" ");
        System.out.println(str1[1].equals("1"));
    }

        public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length - 1);
    }
    public static ListNode merge(ListNode[] lists,int l,int r){
        if(l > r)return null;
        if(l == r)return lists[l];
        int mid = ((r - l) >> 1) + l;
        ListNode nodeA = merge(lists,l,mid);
        ListNode nodeB = merge(lists,mid+1,r);
        return mergeTwoLists(nodeA,nodeB);
    }
    public static ListNode mergeTwoLists(ListNode nodeA,ListNode nodeB){
        ListNode head = new ListNode();
        ListNode curA = nodeA;
        ListNode curB = nodeB;
        ListNode cur = head;
        while(curA != null && curB != null){
            if(curA.val < curB.val){
                cur.next = curA;
                curA = curA.next;
            }
            else{
                cur.next = curB;
                curB = curB.next;
            }
            cur = cur.next;
        }
        if(curA != null)cur.next = curA;
        if(curB != null)cur.next = curB;
        return head.next;
    }
}
