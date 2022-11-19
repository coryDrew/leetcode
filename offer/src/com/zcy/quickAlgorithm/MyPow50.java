package com.zcy.quickAlgorithm;

public class MyPow50 {
    ///快速幂迭代法，空间复杂度o（1）
    //根据从右往左每一位是不是1来判断是否要加入当前的值，具体证明见官解，能基本看懂
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {//判断最低位是否为1   和 N&1 == 1  是一样的
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;//右移一位，舍弃当前最后一位
        }
        return ans;
    }
    //法二：递归快速幂，要消耗栈空间o（n）
    public double myPowbad(double x, int n) {
        long N = n;
        return N>0?quickMul2(x,N):1/quickMul2(x,-N);

    }
    public double quickMul2(double x,long N){
        if(N == 0){
            return 1;
        }
        double y = quickMul(x,N/2);//求得一半的幂 如果N是77这里求的就是38，y就是x的38次方
        return N%2 == 0 ? y*y:y*y*x;//如果N是偶数，就两个y乘就行了；如果N是77，上面求的是x的38次方，两个y就是x的76次方，所以还要再乘一个x
    }

}
