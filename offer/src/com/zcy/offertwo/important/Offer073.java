package com.zcy.offertwo.important;

public class Offer073 {
    //有意思的二分
    public int minEatingSpeed(int[] piles, int h) {
        int L = 1;
        int R = 0;
        for(int pile:piles){
            R = Math.max(pile,R);
        }
        int ans = 0;
        while(L <= R){
            int m = ((R - L) >> 1) + L;
            if(hours(piles,m) <= h){
                ans = m;
                R = m - 1;
            }else{
                L = m + 1;
            }
        }
        return ans;
    }
    private int hours(int[] piles,int speed){
        int ans = 0;

        for(int pile:piles){
            ans+=pile/speed;
            if(pile%speed != 0)ans++;
        }
        return ans;
    }
}
