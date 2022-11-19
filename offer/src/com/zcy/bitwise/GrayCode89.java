package com.zcy.bitwise;

import java.util.ArrayList;
import java.util.List;

public class GrayCode89 {
    //背规律
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < Math.pow(2,n);i++){
            res.add(i^(i/2));
        }
        return res;
    }
}
