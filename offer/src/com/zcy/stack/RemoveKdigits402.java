package com.zcy.stack;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKdigits402 {
    //贪心+单调栈   真恶心啊   和316类似，字符串字典序排序的都可以想到用栈
    public String removeKdigits(String num, int k) {
        //更高位的数字是更决定性的，所以当删除次数达到k时，不用考虑后面低位的数了！！，这也是我理解的贪心的思想
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;//判断是否是前导零的标志位，很妙
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
