package com.zcy.offertwo.important;

public class Offer069 {
    public int peakIndexInMountainArray(int[] arr) {
        //二分
        //简单睡个觉了，总之不要在两端点设置起始指针。
        int len = arr.length;
        int l = 1,r = len - 2;
        while(l <= r){
            int mid = ((r - l)>>1)+l;
            if(arr[mid] > arr[mid - 1]&&arr[mid] > arr[mid + 1]){
                return mid;
            }
            if(arr[mid] > arr[mid + 1]){
                r = mid - 1;
            }
            if(arr[mid] < arr[mid + 1]){
                l = mid + 1;
            }
        }
        return l;
    }
}
