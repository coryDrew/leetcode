package com.zcy.offertwo.important;

public class Offer072 {
    //一下不能错！
    public int mySqrt(int x) {
        int l = 0,r = x;
        if(x == 0)return 0;
        while(l <= r){
            int mid = ((r - l) >> 1) + l;
            if((long)mid * mid == x){
                return mid;
            }
            if((long)mid*mid > x){
                r = mid - 1;
            }
            if((long)mid*mid < x){
                l = mid + 1;
            }
        }
        return r;
    }
}
