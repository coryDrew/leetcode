package com.zcy.offertwo;

public class Offer019 {
    //自写
    public boolean validPalindrome(String s) {
        int l = 0,r = s.length() - 1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return isValid(s.substring(0,l)+s.substring(l+1))||isValid(s.substring(0,r)+s.substring(r+1));
            }
            l++;
            r--;
        }
        return true;
    }
    private boolean isValid(String s){
        int l = 0,r = s.length() - 1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;

        }
        return true;
    }
}
