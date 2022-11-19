package com.zcy.DP.digitDP;

import java.util.ArrayList;
import java.util.List;

public class NumDupDigitsAtMostN1012 {
    // 预处理排列数 f[i][j]=i*(i+1)*...*(j-1)*j
    static int[][] f = new int[11][11];

    static {
        for (int i = 1; i < 11; i++) {
            for (int j = i; j < 11; j++) {
                int cur = 1;
                for (int k = i; k <= j; k++) {
                    cur *= k;
                }
                f[i][j] = cur;
            }
        }
    }

    public int numDupDigitsAtMostN(int n) {
        /*
        数位DP(较难):
        本题可以转化为求[1,n]全部数字不相同的数字个数，是典型的数位DP问题
        数位DP问题求解的总体思路就是求[0,n]中满足某些条件的数字个数
        通常套路就是将[0,n]的数字分为3部分：
        1.res1 位数小于n的部分 这部分与 LC357 解法一致，利用乘法原理求解
        2.res2 位数等于n的部分且最高位小于n 这部分也可以用乘法原理进行求解，枚举最高位直接计算就可以
        3.res3 位数等于n的部分且最高位等于n 这部分是最难的，因为每一位的取值严格被限制了，需要用到DP的思想进行求解
        res2与res3一般放在一起求解，套路如下：
        从高位向低位枚举，假设当前位为cur，其中res2部分可以通过乘法原理计算得到
        res3部分需要由  当前位的后面位方案数  决定
        具体的，res2=[0,cur-1]能用的数字数*后面剩余位数的排列数
                res3相当于固定了当前位为最大值cur，再看后面位的总的方案数，通过for循环一直遍历至最后一位(或者是出现重复的一位)
                排列数的情形有限，我们可以预处理出来加快计算速度
        时间复杂度:O(logN)  空间复杂度:O(C)
         */
        return n - dp(n) + 1;   // 注意排除掉0的情况
    }

    // dp[x]返回[0,x]中每一位都不同的数字数目
    private int dp(int x) {
        // 一位数直接返回x+1(因为包含0)
        if (x <= 9) return x + 1;
        // 将x每一位提出来
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        int bitCnt = list.size();
        int res = 0;
        // 1.计算res1+res2部分
        // 其中i为数字x的位索引，i越大表示位数越高(越左)
        // p记录当前循环到的位置已经遍历了多少位
        // used标记当前遍历过程中已经用了的哪些数字，到时候根据used排除
        for (int i = bitCnt - 1, used = 0, p = 1; i >= 0; i--, p++) {
            // 首先计算当前位cur能用的数字个数cnt
            int cur = list.get(i), cnt = 0;
            // 枚举[cur-1,0]，再排除掉前面已经用过的
            for (int j = cur - 1; j >= 0; j--) {
                // 最高位可以用[cur-1,1]
                if (i == bitCnt - 1) {
                    cnt = cur - 1;
                    break;
                }
                // 低位可以用[cur-1,0]没用过的任意数
                if (((used >> j) & 1) == 0) cnt++;
            }
            // 计算res2部分
            // 合法值 a>=b 其中a为cur后面首位选择数，b为终点(最后一位)的选择数
            int a = 10 - p, b = a - (bitCnt - p) + 1;
            res += cnt * (i > 0 ? f[b][a] : 1);    // 特例为最后一位的时候可以选cnt个
            // 已经遇到相同数字，统计完cnt次以后([0,cur-1]的情况)就可以退出
            if (((used >> cur) & 1) == 1) break;
            if (i == 0) res++;  // 当x本身就是合法案例，最后一位加完cnt之后还要再+1
            used |= (1 << cur);  // 标记使用了cur
        }
        // 2.计算res3部分(位数小于x的部分)
        res += 10;  // 先统计一位数的情况
        // 统计后面的[2,bitCnt-1]位:9*9  9*9*8  9*9*8*7 ...
        for (int i = 2; i < bitCnt; i++) {
            res += 9 * f[11 - i][9];
        }
        return res;
    }
}
