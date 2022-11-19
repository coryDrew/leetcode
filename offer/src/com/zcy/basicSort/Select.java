package com.zcy.basicSort;

import java.util.Arrays;

public class Select {
    public static void main(String[] args) {
        int[] arr = new int[]{14,2,5,1,2,4,8,7,9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr){
        for(int i = 0;i < arr.length;i++){//每轮挑出最小的放在i号位置
            int index = i;
            int min = arr[i];
            for(int j = i + 1;j < arr.length;j++){
                if(arr[j] < min){
                    index = j;
                    min = arr[j];
                }
            }
            swap(arr,i,index);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
