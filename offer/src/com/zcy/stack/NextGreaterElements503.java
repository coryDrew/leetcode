package com.zcy.stack;

public class NextGreaterElements503 {
    //单调栈+循环数组
    /**
     我们注意到，暴力解法中，如果数组的前半部分是单调不增的，那么会有很大的计算资源的浪费。比如说 [6,5,4,3,8]，对于前面的 [6,5,4,3] 等数字都需要向后遍历，当寻找到元素 8 时才找到了比自己大的元素；而如果已知元素 6 向后找到元素 8 才找到了比自己的大的数字，那么对于元素 [5,4,3] 来说，它们都比元素 6 更小，所以比它们更大的元素一定是元素 8，不需要单独遍历对 [5,4,3] 向后遍历一次！

     根据上面的分析可知，可以遍历一次数组，如果元素是单调递减的（则他们的「下一个更大元素」相同），我们就把这些元素保存，直到找到一个较大的元素；把该较大元素逐一跟保存了的元素比较，如果该元素更大，那么它就是前面元素的「下一个更大元素」。

     作者：fuxuemingzhu
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<>();
        //往stack里放的是下标
        for (int i = 0; i < 2 * n; i++) {//2n后取模即可
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}
