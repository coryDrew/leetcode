package com.zcy.quickAlgorithm;

public class Divide29 {
    /**
     快速乘的模版：
     int multiply(int A, int B) {
     int ans = 0;
     for(; B != 0; B >>= 1){
     if(B & 1){
     ans += A;
     }
     A <<= 1;
     }
     return ans;
     } */

    //二分加快速乘，要掌握啊，基本看懂了，主要是快速乘（先看快速幂的迭代法实现，就能看懂！）
    public int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = !rev;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rev ? -ans : ans;
    }

    // 快速乘
    //先看一下快速幂的迭代版本，确实是根据它改得，但是这里由于需求不同，又进行了其他改进，最基本的快速乘见上面的模板
    public boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数   y是除数，x是被除数
        // 需要判断 z * y >= x 是否成立
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x    减法防止溢出
                if (result < x - add) {//还没累加完就已经比x小了，直接退出
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }
}
