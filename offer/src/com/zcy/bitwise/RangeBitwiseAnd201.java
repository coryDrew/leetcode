package com.zcy.bitwise;

public class RangeBitwiseAnd201 {
    //狗都不会
    //不断转化
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m != n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }
}
