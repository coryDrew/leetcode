package com.zcy.tree;
import java.util.*;
public class PreOrderP1030 {
    //根据中序和后序求先序
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String in = sc.nextLine();
            String post = sc.nextLine();
            System.out.println(preOrder(in,post,0,in.length() - 1,0,post.length() - 1));
        }
        public static String preOrder(String in,String post,
                                      int inStart,int inEnd,int pStart,int pEnd){
            if(inStart>inEnd)//这个条件是最关键的！得自己分析一步一步调试才能看出来，得记住
                return"";
            if(inStart==inEnd)return in.charAt(inStart) +"";//这行可以不要
            char head = post.charAt(pEnd);
            int headIndex = in.indexOf(head);
            int lenLeft = headIndex - inStart;
            String left = preOrder(in,post,inStart,headIndex - 1,pStart,
                    pStart+lenLeft - 1);
            String right = preOrder(in,post,headIndex + 1,inEnd,
                    pStart+lenLeft,pEnd - 1);
            return head + left + right;
        }

}
