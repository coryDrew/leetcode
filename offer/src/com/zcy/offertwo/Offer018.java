package com.zcy.offertwo;

public class Offer018 {
    //简单题，但是有很多细节
    //越界问题
    //api调用，忽略大小写可以把都转成小写
    //isletterordigit
    public boolean isPalindrome(String s) {
        int n = s.length();

        int l = 0,r = n - 1;

        while(l < r){
            while(l<r&&!Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l<r&&!Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(Character.toUpperCase(s.charAt(l)) !=Character.toUpperCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;

        }
        return true;
    }
}
