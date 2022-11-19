package com.zcy.binaryIndexedTree;

public class NumArray307 {
    //树状数组模板题
    private int[] tree;
    private int[] nums;

    public NumArray307(int[] nums) {
        this.tree = new int[nums.length + 1];
        this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);//初始化树状数组
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);//要增加的值，在树状数组的某几个位置要更新
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }

    private int lowBit(int x) {
        return x & -x;//最右边的1代表的值
    }

    private void add(int index, int val) {//初始化tree以及更新时用到
        while (index < tree.length) {
            tree[index] += val;
            index += lowBit(index);
        }
    }

    private int prefixSum(int index) {//不包括index位置
        int sum = 0;
        while (index > 0) {//真神了，慢慢记住吧
            sum += tree[index];
            index -= lowBit(index);
        }
        return sum;
    }

}
