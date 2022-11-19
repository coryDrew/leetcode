package com.zcy.offertwo;

public class Offer005 {
    public int maxProduct(String[] words) {
        int[] nums = new int[words.length];
        for(int i = 0;i < words.length;i++){
            for(int j = 0;j < words[i].length();j++){
                nums[i]|=1<<(words[i].charAt(j) - 'a');//1左移一些位，左边是要移位的数，右边是要移多少位

            }
        }
        int ans = 0;
        for(int i = 0;i < nums.length - 1;i++){
            for(int j = i+1;j < nums.length;j++){
                if((nums[i]&nums[j]) == 0){
                    ans = Math.max(ans,words[i].length()*words[j].length());
                }
            }
        }
        return ans;
    }

}
