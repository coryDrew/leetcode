package com.zcy.twoPoints;

public class CircularArrayLoop457 {
    //快慢指针，恶心死了
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (isValidCircular(nums, i)) return true;
        }
        return false;
    }

    private boolean isValidCircular(int[] nums, int start) {
        int f = next(nums, next(nums, start)), s = start;
        boolean isValid = true;
        while (f != s) {
            // 如果发现next节点为0，表明进入一个无效循环
            if (nums[f] == 0 || nums[s] == 0) {
                isValid = false;
                break;
            }
            f = next(nums, next(nums, f));
            s = next(nums, s);
        }
        // 如果已发现无效，标记start做起点的整条路无效
        if (!isValid) {
            setTag(nums, start);
            return false;
        }
        // 继续检查环路有效性：
        boolean isPositive = nums[s] > 0;
        int k = 1, next;
        while ((next = next(nums, s)) != f) {
            s = next;
            if ((nums[s] > 0) ^ isPositive) {
                isValid = false;
                break;
            }
            k++;
        }
        isValid = isValid && k > 1;
        // 如果已发现无效，标记start做起点的整条路无效
        if (!isValid) {
            setTag(nums, start);
        }

        return isValid;
    }

    // 标记start做起点的整条路无效
    private void setTag(int[] nums, int start) {
        int cur = start, next;
        while ((next = next(nums, cur)) != start && next != cur) {
            nums[cur] = 0;
            cur = next;
        }
        nums[start] = 0;
    }

    private int next(int[] nums, int cur) {
        int steps = nums[cur] % nums.length;
        int next = cur + steps;
        return (next + nums.length) % nums.length;
    }
}
