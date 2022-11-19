package com.zcy.bitwise;

public class SuperPow372 {
    //快速幂
    //乘法在取模的意义下满足分配律，即
    //
    //(a \cdot b) \bmod m = [(a \bmod m) \cdot (b \bmod m)] \bmod m
    //(a⋅b)modm=[(amodm)⋅(bmodm)]modm
    static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = (int) ((long) ans * pow(a, b[i]) % MOD);
            a = pow(a, 10);
        }
        return ans;
    }

    public int pow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if (n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long) x * x % MOD);
            n /= 2;
        }
        return res;
    }
}
