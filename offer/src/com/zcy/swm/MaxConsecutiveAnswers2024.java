package com.zcy.swm;

public class MaxConsecutiveAnswers2024 {
    //和424一样的，这两题都是左开右闭区间，要不然好像不太好表示
    //自写
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] cnt = new int[2];
        int l = 0,r = 0;
        int max = 0;
        int len = answerKey.length();
        while(r < len){

            if(answerKey.charAt(r) == 'T'){
                cnt[0]++;
                max = Math.max(max,cnt[0]);
            }else{
                cnt[1]++;
                max = Math.max(max,cnt[1]);
            }
            r++;
            if(r - l - max > k){
                if(answerKey.charAt(l) == 'T'){
                    cnt[0]--;

                }else{
                    cnt[1]--;
                }
                l++;
            }
        }
        return r - l;
    }
}
