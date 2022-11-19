package com.zcy.swm;

public class EqualSubstring1208 {
    //diff数组，很方便，可是想不出来
    public int equalSubstring(String s, String t, int maxCost) {
        int[] diff = new int[s.length()];
        for(int i = 0;i < s.length();i++){
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int l = 0,r =0;
        int sum = 0;
        int res = 0;
        while(r < s.length()){
            sum += diff[r];
            if(sum <= maxCost){
                res = Math.max(res,r - l + 1);
            }else{
                sum-=diff[l];
                l++;
            }
            r++;
        }
        return res;

    }
}
