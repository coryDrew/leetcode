package com.zcy.basicSort;

import com.zcy.tree.BalanceBST1382;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,2,6,3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length;i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, j, j + 1);
                }
            }
            if (flag == false) break;
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
