package com.zcy.tree;

import java.util.LinkedList;
import java.util.List;

public class PathInZigZagTree1104 {
    //CV
    /**
     位运算即可。具体解释见题解。

     举例14=1110b，

     先将14右移，变为111b，然后对除第一位外所有位取反变为100b，即它的根节点4，

     同理100b，右移变为10b，对除第一位外所有位取反变为11b，即它的根节点3

     一直到1结束。
     */
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> res = new LinkedList<>();
        res.add(label);
        int c = (int) (Math.log(label) / Math.log(2));
        while (c != 0) {
            label = (int) (Math.pow(2, c) - 1) + (int) (Math.pow(2, c - 1)) - label / 2;
            res.addFirst(label);
            c--;
        }
        return res;
    }
}
