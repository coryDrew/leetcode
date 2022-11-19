package com.zcy.DP;

import java.util.Arrays;

public class Jump45 {

    public static void main(String[] args) {
        int[] nums=  new int[]{2,3,0,1,4};
        System.out.println(jumpDP(nums));
    }
    //官方贪心：
    //倒过来，逆向思维
    //我们的目标是到达数组的最后一个位置，因此我们可以考虑最后一步跳跃前所在的位置，该位置通过跳跃能够到达最后一个位置。
    //
    //如果有多个位置通过跳跃都能够到达最后一个位置，那么我们应该如何进行选择呢？直观上来看，我们可以「贪心」地选择距离最后一个位置最远的那个位置，也就是对应下标最小的那个位置。因此，我们可以从左到右遍历数组，选择第一个满足要求的位置。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode.cn/problems/jump-game-ii/solution/tiao-yue-you-xi-ii-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int jump(int[] nums) {
        int pos = nums.length - 1;
        int step = 0;
        while(pos>0){
            for(int i = 0;i < pos;i++){
                if(i+nums[i]>=pos){
                    pos = i;
                    step++;
                    break;
                }
            }
        }
        return step;
    }
    //**********************动态规划！***************************
    //看完贪心再看动态规划，会感觉有很多多余操作的
    public static int jumpDP(int[] nums) {
        //可以用dp的，mlgb
        //dp[i]表示从i下标跳到最后下标最少要跳几次，逆向思维啊！
        //但是dp速度很慢，击败10
        //拓展一下思维
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp,100000);//这里用Integer.MAX_VALUE来填会溢出，意向不到的结果
        dp[nums.length - 1] = 0;
        for(int i = nums.length - 2;i>=0;i--){
            if(i+nums[i]>=nums.length - 1){
                dp[i] = 1;
                continue;
            }
            for(int j = i + 1;j <=i + nums[i];j++){
                dp[i]=Math.min(dp[i], dp[j]);

            }
            dp[i] += 1;
        }
        return dp[0];
    }
}
