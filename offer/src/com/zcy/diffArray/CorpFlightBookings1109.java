package com.zcy.diffArray;

public class CorpFlightBookings1109 {
    //差分数组模板题
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        int[] diff = new int[n + 1];
        for(int i = 0;i < bookings.length;i++){
            diff[bookings[i][0] - 1]+=bookings[i][2];
            diff[bookings[i][1]]-=bookings[i][2];
        }
        int base = 0;
        for(int i = 0;i < n;i++){
            res[i] = base + diff[i];
            base = res[i];
        }
        return res;
    }
}
