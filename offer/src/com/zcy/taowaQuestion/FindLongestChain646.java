package com.zcy.taowaQuestion;

import java.util.Arrays;

public class FindLongestChain646 {
    //都一样的题
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(x, y)->(x[0] - y[0]));

        int res = 1;
        int[] dp = new int[pairs.length];
        Arrays.fill(dp,1);
        for(int i = 0;i < pairs.length;i++){
            for(int j = 0;j < i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    //贪心
    public int findLongestChain666(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) if (cur < pair[0]) {
            cur = pair[1];
            ans++;
        }
        return ans;
    }

}
