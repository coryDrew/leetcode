package com.zcy.bitwise;

public class MaxProduct318 {
    //判断两个单词是否有重复字母，用位运算，26位int，哪一位是1就代表出现了哪个字母，很简单的
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] mask = new int[len];
        for(int i = 0;i < len;i++){
            for(int j = 0;j < words[i].length();j++){
                mask[i]|=1<<(words[i].charAt(j) - 'a');
            }
        }
        int max = 0;
        for(int i = 0;i < len;i++){
            for(int j = i+1;j < len;j++){
                if((mask[i]&mask[j]) == 0){
                    max = Math.max(words[i].length()*words[j].length(),max);
                }
            }
        }
        return max;
    }
}
