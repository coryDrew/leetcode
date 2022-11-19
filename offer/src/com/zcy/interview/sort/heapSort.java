package com.zcy.interview.sort;

public class heapSort {
    /*
    说一下思路：
    把数组抽象成一个完全二叉树（左子节点2i+1，右子节点2i+2）
    对数组进行堆化，如堆化成大顶堆（父节点的值大于两个子节点，递归满足）
    然后将堆顶元素与堆的最后一个元素互换，此时就能找到最大的元素，并将其放在了正确的位置（最后一位，升序排列）
    然后将最后一个元素除外，重复上述动作，堆化+互换
    最终得到一个升序排列的数组
    * */
}
