package com.zcy.bitwise;

import java.util.HashSet;
import java.util.Set;

public class ReorderedPowerOf2869 {
    /**
     由于我们可以按任何顺序将数字重新排序，因此对于两个不同的整数 aa 和 bb，如果其十进制表示的字符数组，从小到大排序后的结果是相同的，那么若 aa 能够重排得到 22 的幂，bb 也可以；若 aa 不能重排得到 22 的幂，那么 bb 也不能。

     进一步地，只要 aa 和 bb 的十进制表示的字符数组中，从 \texttt{0}0 到 \texttt{9}9 每个字符的出现次数，在 aa 和 bb 中都是一样的，那么 aa 和 bb 能否重排得到 22 的幂的结果是一样的。

     由于 2^{29} < 10^9 < 2^{30}2
     29
     <10
     9
     <2
     30
     ，因此在 [1,10^9][1,10
     9
     ] 范围内有 2^0,2^1,\cdots,2^{29}2
     0
     ,2
     1
     ,⋯,2
     29
     一共 3030 个 22 的幂。对这 3030 个数的每个数，我们可以预处理其十进制表示的字符数组中从 \texttt{0}0 到 \texttt{9}9 每个字符的出现次数，记在一个长度为 1010 的数组中，并用一哈希表记录这些数组。对于数字 nn，我们同样统计其十进制表示的字符数组中从 \texttt{0}0 到 \texttt{9}9 每个字符的出现次数，然后去哈希表中查找，若存在则说明 nn 可以通过重排得到 22 的幂，否则不能。


     */
    Set<String> powerOf2Digits = new HashSet<String>();

    public boolean reorderedPowerOf2(int n) {
        init();
        return powerOf2Digits.contains(countDigits(n));
    }

    public void init() {
        for (int n = 1; n <= 1e9; n <<= 1) {//枚举2的1次方，2的2次方。。。。
            powerOf2Digits.add(countDigits(n));
        }
    }

    public String countDigits(int n) {//取到每一位，先&再/
        char[] cnt = new char[10];
        while (n > 0) {//取到每一位，记录所有数字的出现次数
            ++cnt[n % 10];//对char也能直接++？
            n /= 10;
        }
        return new String(cnt);//将数组转成字符串
    }

}
