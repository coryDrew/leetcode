package com.zcy.wc309;

public class LongestNiceSubArray6169 {

    /**
     如果两个数 AND 的结果不是 0，说明这两个数的某个二进制位都是 1。因此我们需要选出最长的区间，使得区间中每个二进制位最多出现一个 1。 */

    //法一：感觉有点煞笔
    // 将 bits 翻译成对应的数字
    private int getBits(int[] bits) {
        int res = 0;
        for (int i = 0; i < 32; i++)
            if (bits[i] != 0)
                res |= 1 << i;
        return res;
    }

    // 去除某个数字对应的全部位
    private void removeBits(int[] bits, int num) {
        for (int i = 0; i < 32; i++)
            if ((num & (1 << i)) != 0)
                bits[i]--;
    }

    // 增加某个数字对应的全部位
    private void addBits(int[] bits, int num) {
        for (int i = 0; i < 32; i++)
            if ((num & (1 << i)) != 0)
                bits[i]++;
    }

    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int res = 1;
        int[] bits = new int[32];
        for (int i = 0, j = 0; j < n; j++) {
            // 如果先前数字或运算的结果和当前数字与运算不为 0，说明不满足条件，开始压缩窗口
            while ((getBits(bits) & nums[j]) != 0)
                removeBits(bits, nums[i++]);
            // 将当前数字添加到窗口中
            addBits(bits, nums[j]);
            // 更新最大长度
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
    //好理解的方法
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int [] cnt = new int[32];  // 记录每一位上1的个数
        int total = 0; // 记录 总共超出的1的个数
        int ans = 1;
        for (int l = 0,r = 0;r < n;r++){
            // 将nums[r]加入到窗口中
            for (int i = 0;i < 32;i++){
                if (((nums[r] >> i) & 1) == 1)
                {
                    cnt[i] += 1;
                    // 如果当前位1的个数超过1，更新total
                    if (cnt[i] > 1){
                        total += 1;
                    }
                }
            }
            while (total > 0){
                for (int i = 0;i < 32;i++){
                    if (((nums[l] >> i) & 1) == 1){
                        cnt[i] -= 1;
                        // 如果当前位减去的1的个数是超过的，更新total
                        if (cnt[i] >= 1){
                            total -=1;
                        }
                    }
                }
                l++; // 缩小窗口
            }
            ans = Math.max(ans,r - l + 1);
        }
        return ans;
    }


}
