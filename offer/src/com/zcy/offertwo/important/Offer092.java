package com.zcy.offertwo.important;

public class Offer092 {
    //动态规划还是想不到啊
        //重要：不一定只依赖于前面的结果，还有可能有其他可能，比如这里的one！
        //自己每次想的时候只停留在与前一项的关系，没有考虑其他可能性！！！！！！导致想不出来
        public static int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int one = s.charAt(0) == '1'? 1:0;
        for(int i = 1;i < len;i++){

            if(s.charAt(i) == '0'){
                dp[i] = Math.min(dp[i - 1]+1,one);//两种可能，改或不改！
            }else{
                one++;
                dp[i]  = dp[i - 1];
            }

        }
        return dp[len - 1];
    }
}
