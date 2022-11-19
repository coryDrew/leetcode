package com.zcy.shuffleAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shuffle384 {
    /**
     首先，我们考虑如何随机打乱一个数组。

     不妨设数组 \textit{nums}nums，其长度为 nn。我们可以使用如下方法打乱：

     将数组中所有的数都放到数据结构 \textit{waiting}waiting 中，并初始化打乱后的数组 \textit{shuffle}shuffle；
     循环 nn 次，在第 ii 次循环中（0 \le i < n0≤i<n）：
     在 \textit{waiting}waiting 中随机抽取一个数 \textit{num}num，将其作为打乱后的数组 \textit{shuffle}shuffle 的第 ii 个元素；
     从 \textit{waiting}waiting 中移除 \textit{num}num。
     对于原数组 \textit{nums}nums 中的数 \textit{num}num 来说，被移动到打乱后的数组的第 ii 个位置的概率为：

     P(i) = \begin{cases} (\frac{n-1}{n} \times \frac{n-2}{n-1} \cdots \times \frac{n-i}{n-i+1}) \times \frac{1}{n-i} = \frac{1}{n}, \hspace{1em} i > 0 \\ \frac{1}{n}, \hspace{1em} i = 0 \end{cases}
     P(i)={
     (
     n
     n−1
     ​
     ×
     n−1
     n−2
     ​
     ⋯×
     n−i+1
     n−i
     ​
     )×
     n−i
     1
     ​
     =
     n
     1
     ​
     ,i>0
     n
     1
     ​
     ,i=0
     ​


     因此，对于原数组 \textit{nums}nums 中的任意一个数，被移动到打乱后的数组的任意一个位置的概率都是相同的。
     如何实现 \textit{waiting}waiting？

     我们要求 \textit{waiting}waiting 既支持根据随机计算的下标获取元素，又支持根据该下标移除元素。
     java即可使用list
     */
    int[] arr;
    int[] clone;
    public Shuffle384(int[] nums) {
        arr = nums;
        clone = arr.clone();
    }

    public int[] reset() {
        arr = clone.clone();
        return arr;
    }

    public int[] shuffle() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            list.add(arr[i]);
        }
        Random random = new Random();
        for (int i = 0; i < arr.length; ++i) {
            int j = random.nextInt(list.size());
            arr[i] = list.remove(j);
        }
        return arr;
    }
}
