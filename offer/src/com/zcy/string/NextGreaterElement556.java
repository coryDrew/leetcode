package com.zcy.string;

import java.util.Arrays;

public class NextGreaterElement556 {
    public static void main(String[] args){
        System.out.println('4'>'3');
    }
    //写的像屎一样，过了
    //思路
    //找到第一个比右边小的数字，然后从右往左（从这个数字的索引+1位置到最后一个位置）找比这个数字大的最小数字，将这两个数字交换，
    //最后将这个数字的索引+1位置到最后的位置  从小到大排序
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char[] ch = s.toCharArray();
        int index = -1;
        for(int i = ch.length - 1;i >0;i--){
            if(ch[i]>ch[i - 1]){
                index = i - 1;
                break;
            }

        }
        if(index == -1)return -1;
        int leastbigIndex = -1;//这里只要从右往左找到第一个比他大的就行了，因为这里的序列肯定是降序排列的
        char leastbig = ' ';
        for(int i = ch.length - 1;i>index;i--){
            if(leastbig == ' '&&ch[i]> ch[index]){
                leastbig = ch[i];
                leastbigIndex = i;
            }
            if(leastbig != ' '){
                if(ch[i] < leastbig && ch[i]> ch[index]){
                    leastbig = ch[i];
                    leastbigIndex = i;
                }
            }

        }
        swap(ch,index,leastbigIndex);
        String ss = new String(ch);
        String sub = ss.substring(index+1,ss.length());//这部分排序
        char[] subch = sub.toCharArray();
        Arrays.sort(subch);
        for(int i = index + 1;i<ch.length;i++){
            ch[i] = subch[i - index - 1];
        }
        String res = new String(ch);
        long x = Long.valueOf(res);
        return x>2147483647?-1:(int)x;
    }
    public void swap(char[] ch,int x,int y){
        char tmp;
        tmp = ch[x];
        ch[x] = ch[y];
        ch[y] = tmp;
    }
}
