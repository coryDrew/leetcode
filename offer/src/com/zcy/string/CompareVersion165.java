package com.zcy.string;

public class CompareVersion165 {
    //面试可能不给用split函数！！！！
    public static void main(String[] args) {
        String v1 = "0.1";
        String v2 = "1.1";
        System.out.println(compareVersion(v1,v2));
    }
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");//分割. 要加转义字符！！！！！！！！！！
        String[] v2 = version2.split("\\.");
        int len = Math.min(v1.length,v2.length);
        for(int i = 0;i < len;i++){
            int j = 0;
            int k = 0;
            int cnt1 = 0;
            int cnt2 = 0;

            cnt1 = Integer.valueOf(v1[i]);


            cnt2 = Integer.valueOf(v2[i]);

            if(cnt1 < cnt2){
                return -1;
            }
            if(cnt1 > cnt2){
                return 1;
            }
        }
        if(v1.length == v2.length){
            return 0;
        }else if(v1.length > v2.length){
            for(int i = v2.length;i < v1.length;i++){
                if(Integer.valueOf(v1[i]) != 0){
                    return 1;
                }
            }
            return 0;
        }else{
            for(int i = v1.length;i < v2.length;i++){
                if(Integer.valueOf(v2[i]) != 0){
                    return -1;
                }
            }
            return 0;
        }
    }
    //********************官方不用split********************
    //双指针疯狂遍历
    public int compareVersionNoSplit(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }


}
