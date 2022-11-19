package com.zcy.greedy;

public class IncreasingTriplet334 {
    //法一：双向遍历 时间空间都是o（n）
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int[] leftMin = new int[len];
        int[] rightMax = new int[len];
        leftMin[0] = nums[0];
        for(int i = 1;i < len;i++){
            leftMin[i] = Math.min(nums[i],leftMin[i - 1]);
        }
        rightMax[len - 1] = nums[len - 1];
        for(int i = len - 2;i>=0;i--){
            rightMax[i] = Math.max(nums[i],rightMax[i+1]);
        }
        for(int i = 0;i < len;i++){
            if(leftMin[i]<nums[i]&&nums[i] < rightMax[i]){
                return true;
            }
        }
        return false;
    }
    //法二：贪心，空间优化至o（1）
    //太难想了这个
    /*
    可以使用贪心的方法将空间复杂度降到 O(1)O(1)。从左到右遍历数组 \textit{nums}nums，遍历过程中维护两个变量 \textit{first}first 和 \textit{second}second，分别表示递增的三元子序列中的第一个数和第二个数，任何时候都有 \textit{first} < \textit{second}first<second。

初始时，\textit{first} = \textit{nums}[0]first=nums[0]，\textit{second} = +\inftysecond=+∞。对于 1 \le i < n1≤i<n，当遍历到下标 ii 时，令 \textit{num} = \textit{nums}[i]num=nums[i]，进行如下操作：

如果 \textit{num} > \textit{second}num>second，则找到了一个递增的三元子序列，返回 \text{true}true；

否则，如果 \textit{num} > \textit{first}num>first，则将 \textit{second}second 的值更新为 \textit{num}num；

否则，将 \textit{first}first 的值更新为 \textit{num}num。

如果遍历结束时没有找到递增的三元子序列，返回 \text{false}false。

上述做法的贪心思想是：为了找到递增的三元子序列，\textit{first}first 和 \textit{second}second 应该尽可能地小，此时找到递增的三元子序列的可能性更大。

    用人话说就是：
赋初始值的时候，已经满足second > first了，现在找第三个数third
(1) 如果third比second大，那就是找到了，直接返回true
(2) 如果third比second小，但是比first大，那就把second的值设为third，然后继续遍历找third
(3) 如果third比first还小，那就把first的值设为third，然后继续遍历找third（这样的话first会跑到second的后边，但是不要紧，因为在second的前边，老first还是满足的）
    * */
    public boolean increasingTripletGreedy(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }

}
