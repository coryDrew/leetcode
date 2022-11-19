package com.zcy.brainteasers;

public class CanTransform777 {
    //脑筋急转弯是吧
    public boolean canTransform(String start, String end) {
        if(!start.replaceAll("X","").equals(end.replaceAll("X","")))
            return false;
        int i = 0,j = 0;
        while(i < start.length()){
            if(start.charAt(i) == 'X'){
                i++;
                continue;
            }
            while(end.charAt(j) == 'X')j++;
            if(i<j&&start.charAt(i) == 'L')return false;
            if(i>j&&start.charAt(i) == 'R')return false;
            i++;
            j++;
        }
        return true;
    }
}
