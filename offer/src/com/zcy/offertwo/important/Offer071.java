package com.zcy.offertwo.important;

import java.util.Random;

public class Offer071 {
    //彩票算法，可二分优化
    int[] w;
    int size;
    Random r;

    public Solution(int[] w) {
        this.w = w;
        r = new Random();
        for(int n:w){
            size+=n;
        }

    }

    public int pickIndex() {
        int x = r.nextInt(size);
        int sum = 0;
        for(int i = 0;i < w.length;i++){
            if((sum+=w[i]) > x){//想不出来
                return i;
            }
        }
        return -1;//不会走到这一步
    }
}
