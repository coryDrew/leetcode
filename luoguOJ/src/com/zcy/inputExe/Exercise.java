package com.zcy.inputExe;

import java.util.Scanner;

public class Exercise {
    //Scanner类默认的分隔符就是空格
    /*6.next() 与 nextLine() 区别
next():

1、一定要读取到有效字符后才可以结束输入。
2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
next() 不能得到带有空格的字符串。
nextLine()：

1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
2、可以获得空白。


    * */
    public static void main(String[] args){
//        //一直输入模板
       Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            //******************
//            System.out.println(sc.next());//调用next后会指向后一个元素，但是当没有元素时，会阻塞而不是退出while
//        }
        //一直输入的修正(以#为结束符)
        while(!sc.hasNext("#")){
            System.out.println(sc.next());
        }
//        //有输入的个数
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        while(n>0){
//            //*****************
//            n--;
//        }
        //输入是一个链表
        //输入是一个树
    }
}
