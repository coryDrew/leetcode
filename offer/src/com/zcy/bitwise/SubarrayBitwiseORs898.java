package com.zcy.bitwise;

import java.util.HashSet;
import java.util.Set;

public class SubarrayBitwiseORs898 {
    /**
     解题思路
     暴力算法，枚举出子数组的左端点，然后从它开始进行 或 操作，直到数组末尾
     也就是 or(i,j) = o(i,j-1) | arr[j]
     但是这样会超时，需要再进行改进


     暴力算法超时是因为计算 [i,j] 这个区间的 或 时，实际上中间过程【算是】已经计算了一次 [i+1,j] [i+2,j] ... 等等的值
     但是没有保存这些结果，后续i++又会再计算这些
     这里只是【算是】计算了 [i+1,j] [i+2,j] ... 是因为它们已经和 [i,i+1] [i,i+2] ... 的进行了 或 运算，没办法保存下来
     如果把外层循环改为 j++，内存循环变为 i--，便可以直接保存这些结果


     因为题目只需要去重后的结果，因此可以用set保存 [i+1,j] [i+2,j] ... 结果
     外层循环 j=j+1 时，只需要把新的arr[j]和上一次的所有结果进行计算，不再需要内层循环 i-- 去一个个计算，就能得到 j=j+1 时的所有结果
     这样内层循环从 i-- 变为 遍历上一次的所有结果
     根据 或 运算的性质，以及题目要求去重这一点，能够减少内层循环次数，减少到最多32次

     代码
     */
    public int subarrayBitwiseORs(int[] arr) {
        // 题目有假设，不做校验
        Set<Integer> allResult = new HashSet<>();
        Set<Integer> lastResult = new HashSet<>();
        lastResult.add(arr[0]);
        allResult.add(arr[0]);
        // i为左端点，j为右端点，这里不再需要i
        // 从第二个数开始循环
        for (int j = 1; j < arr.length; j++) {
            Set<Integer> thisResult = new HashSet<>();
            // 添加本次不进行 或 运算的单个结果
            thisResult.add(arr[j]);
            // 添加本次进行 或 运算的新的结果
            for (int r : lastResult) {
                thisResult.add(r | arr[j]);
            }
            lastResult = thisResult;
            //last变成上一轮的结果，存储 i~j，i+1~j，i+2~j...的结果，下一轮只要将第j+1个数和这些结果异或，即可得到i~j+1，i+1~j+1...的结果，太牛了
            // 添加到最终结果中去
            allResult.addAll(thisResult);
        }
        return allResult.size();
    }
}
