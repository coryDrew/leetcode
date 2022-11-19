package com.zcy.interview.string;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class DecodeString394 {
    //倒了血霉
    /**
     * 双栈解法：
     * 准备两个栈，一个存放数字，一个存放字符串
     * 遍历字符串分4中情况
     * 一、如果是数字 将字符转成整型数字 注意数字不一定是个位 有可能是十位，百位等 所以digit = digit*10 + ch - '0';
     * 二、如果是字符 直接将字符放在临时字符串中
     * 三、如果是"[" 将临时数字和临时字符串入栈
     * 四、如果是"]" 将数字和字符串出栈 此时临时字符串res = 出栈字符串 + 出栈数字*res
     */
    public static void main(String[] args){
        decodeString("3[a]2[bc]");
        HashMap
    }
    public static String decodeString(String s) {
        //创建数字栈，创建字符串栈 及临时数字和临时字符串
        Deque<Integer> stack_digit = new LinkedList<>();
        Deque<StringBuilder> stack_string = new LinkedList<>();
        int digit = 0;
        StringBuilder res = new StringBuilder();
        //遍历字符串 分4中情况
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                //如果是"[" 将临时数字和临时字符串入栈
                stack_digit.push(digit);
                stack_string.push(res);
                digit = 0;
                res = new StringBuilder();//这句最关键的，ctm的
            }else if (ch == ']') {
                //如果是"]" 将数字和字符串出栈 此时临时字符串res = 出栈字符串 + 出栈数字*res
                StringBuilder temp = stack_string.poll();
                int count = stack_digit.poll();
                for (int j = 0; j < count; j++) {
                    temp.append(res.toString());
                }
                res = temp;
            }else if (Character.isDigit(ch)) {
                //如果是数字 将字符转成整型数字 ch-‘0’。 注意数字不一定是个位 比如100[a] 所以digit要*10
                digit = digit*10 + ch - '0';
            }else {
                //如果是字符 直接将字符放在临时字符串中
                res.append(ch);
            }
        }
        return res.toString();
    }
}
