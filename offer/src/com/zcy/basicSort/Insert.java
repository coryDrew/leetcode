package com.zcy.basicSort;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,3,0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static  void insertSort(int[] arr){
        for(int i = 1;i < arr.length;i++){//每一轮保证0~i有序
            int j = i;
            while(j > 0 && arr[j] <arr[j - 1]){
                swap(arr,j,j - 1);
                j--;
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
