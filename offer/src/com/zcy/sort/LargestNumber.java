package com.zcy.sort;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        //并不是按照字典序排
        //根据str1+str2和str2+str1的大小关系确定这两个数的排位
        //泛型的类型不能是基本数据类型
        //Comparator<>的compare方法针对的是泛型，int是基本数据类型，要先转成Integer
        //之前那些为啥能直接写，因为那都是二维数组，对应到每个元素就是一维数组类型，数组不是基本数据类型，可以被泛型接受！！！！！！！！
        //Queue<Integer> A = new PriorityQueue<>((x, y) -> (y - x));大顶堆为啥能这样写，因为人家定义时用的就是Integer，可以被泛型接受！！
        //int compare(T o1, T o2);
        //Arrays.sort(nums,(x,y)->(x - y));错误！！
        //Comparator
        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        Arrays.sort(array,(x, y)->{
            String str1 = String.valueOf(x);
            String str2 = String.valueOf(y);
            String sum1 = str1+str2;
            String sum2 = str2+str1;
            return sum2.compareTo(sum1);
        });
        if (array[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < array.length;i++){
            sb.append(String.valueOf(array[i]));
        }
        return sb.toString();
    }
}
