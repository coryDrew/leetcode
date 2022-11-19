package com.zcy.generalUse;

import java.util.ArrayList;

public class ListtoArray {
    //集合转为对象数组
    ArrayList<Integer> list = new ArrayList<>();
    Object[] objects = list.toArray();
    Integer[] integers = list.toArray(new Integer[0]);
    //但是集合是不能通过toArray()方法直接转换成基本数据类型数组的，此时我们就要通过第二种方法了，也就是流式编程

    //集合转为基本类型数组
    ArrayList<Integer> list1 = new ArrayList<>();
    int[] ints = list1.stream().mapToInt(x -> x).toArray();
//通过stream()方法拿到流对象，mapToInt拿到Int流对象，就可以toArray返回int数组了
//这里x->x是lambda表达式，对应一个函数式接口，因为集合中泛型为Interger类型，自动拆箱功能，所以直接返回x就行
//如果这里式String泛型要转为int数组的话，就要调用Integer.parseInt()方法，lambda写法：mapToInt(Integer::parseInt)

}
