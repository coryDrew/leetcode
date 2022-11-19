package com.zcy.swm;

public class MaxTurbulenceSize978 {
    public int maxTurbulenceSize(int[] arr) {
        int l = 0,r = 1;
        int len = arr.length;
        int res = 1;
        int cur = 0;
        int flag = 0;//flag0代表上一个是>关系，是1代表上一个是<关系
        while(r < len){
            if(arr[r] == arr[l]){//相等不符合情况
                r++;
                l++;
                res = Math.max(res,cur);
                cur = 0;
                continue;
            }
            if(arr[r] > arr[l]&&(flag == 1 || cur == 0)){
                if(cur == 0){
                    cur+=2;
                }else{
                    cur++;
                }
                r++;
                l++;
                flag = 0;
                continue;
            }
            if(arr[r] < arr[l]&&(flag == 0 || cur == 0)){
                if(cur == 0){
                    cur+=2;
                }else{
                    cur++;
                }
                r++;
                l++;
                flag = 1;
                continue;
            }
            //剩余的不符合情况
            res = Math.max(res,cur);
            cur = 0;

        }
        res = res = Math.max(res,cur);
        return res;
    }
}
