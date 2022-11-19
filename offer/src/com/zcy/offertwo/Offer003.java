package com.zcy.offertwo;

public class Offer003 {
    public int[] countBits(int n) {
        int [] res = new int[n+1];
        for(int i = 0;i <= n;i++){
            res[i] = count(i);
        }
        return res;
    }
    private int count(int x){
        //算一个数的二进制表示有多少个1
        int res = 0;
        while(x != 0){
            x = x&(x - 1);
            res++;
        }
        return res;
    }
}
