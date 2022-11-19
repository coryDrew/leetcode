package com.zcy.generalUse;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {
    public static void main(String[] args) {
        //测试创建对象时的写法是否影响方法的调用
        LinkedList<Integer> list = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();//左边写的是List接口，能否调用Deque接口特有的方法？好像不能啊
        Deque<Integer> list2 = new LinkedList<>();//左边写的是Deque接口，能否调用List接口特有的方法？应该也不能吧
        //原理是什么？    我的理解是编译看左，运行看右！
        list.addLast();
        list1.addLast();
        list2.addLast();
    }

}
