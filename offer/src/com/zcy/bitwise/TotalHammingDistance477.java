package com.zcy.bitwise;

public class TotalHammingDistance477 {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1;j < nums.length; j++){
                res += getHamm(nums[i],nums[j]);
            }
        }
        return res;
    }
    private int getHamm(int x,int y){
        return Integer.bitCount(x^y);
    }
    //官方
    //n*（n-c）的理解：对汉明距离有贡献的只有1 ^ 0，某位上有c个1，每个1对应n - c个0，总贡献就是c * (n - c)呀
    public int totalHammingDistanceBetter(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }


}
