package com.zcy.basicSort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = new int[]{14,2,5,1,2,4,8,7,9};
        quickSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    //根据黑马的八股教程写的
    //双边快排
    //几个要点：
    //1.递归中结束循环条件必须是l>=h 如果写l == h 是错的
    //2.patition的内层while要写i<j,否则可能出现i和j错开的情况
    //3.arr[i] <= pv 这里必须写小于等于，要不会把基准位置直接和j位置交换值
    public static void  quickSort(int[] arr,int l,int h){
        if(l >= h) return;
       int index =  patition(arr,l,h);
        quickSort(arr,l,index - 1);
        quickSort(arr,index + 1,h);
    }
    public static int patition(int[] arr,int l,int h){//返回排好一轮序之后基准点的位置
        int pv = arr[l];
        int i = l;
        int j = h;
        while(i<j){
            //j从右往左找比pv小的，然后停下
            while(i < j && arr[j] > pv){
                j--;
            }
            while(i < j && arr[i] <= pv){
                i++;
            }
            swap(arr,i,j);
        }
        swap(arr,l,i);
        return i;
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
