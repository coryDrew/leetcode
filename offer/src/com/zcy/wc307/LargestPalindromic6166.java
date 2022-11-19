package com.zcy.wc307;

import java.util.ArrayList;
import java.util.List;

public class LargestPalindromic6166 {
    //自写错误！
    //比赛结束后自己调出来了，就差一个特殊情况没判断！
    public static void main(String[] args) {
        String num = "124348204";
        largestPalindromic(num);
    }
    public static String largestPalindromic(String num) {
        List<Integer> cnt = new ArrayList<>();//记录每个数出现的次数，cnt.get(i)就是i的出现次数
        for(int i = 0;i < 10;i++){
            cnt.add(0);
        }
        for(int i = 0;i < num.length();i++){
            int x=  (num.charAt(i) - 48);
            cnt.set(x,cnt.get(x) + 1);
        }
        //可以存在一个单独的数（处于最中间），这个单独数越大越好
        int solo = -1;
        StringBuilder sb = new StringBuilder();
        for(int i = 9;i>=0;i--){
            if(i == 0&&sb.length() == 0){
                break;
            }
            int c = cnt.get(i);
            if(c == 0){
                continue;
            }
            if(c %2 != 0&&solo == -1){//有余数
                solo = i;
                //i这个数前面加c/2个，后面加c/2个
            }
            String s = String.valueOf(i);
            for(int j = 0;j < c/2;j++){
                sb.append(s);
            }
        }
        String s = sb.toString();//先把数据存了
        StringBuilder rev = sb.reverse();//stringbuilder方法不熟悉，reverse会倒转自身的！！！！！
        String r = rev.toString();
        if(solo != -1){
            s+=(String.valueOf(solo));

        }
        s+= rev.toString();
        return s.equals("")?"0":s;

    }
}
