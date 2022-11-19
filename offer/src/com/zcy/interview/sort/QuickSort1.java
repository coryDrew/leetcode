package com.zcy.interview.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,324};
        sort(arr,0,3);
        System.out.println(Arrays.toString(arr));
    }
    //两个函数，一个是排序的递归函数，
    // 一个是patition函数，用来确定一个点的位置，并将比他大的放在右边，小的放在左边，下面就将他的左边和她的右边进行排序即可
    //patition注意点：
    //1.有返回值  返回基准点确定的位置
    //2.nums[i]<=pv
    //3.内部也要控制i<i
    //4.必须先从右往左找！！！
    public static void sort(int[] nums,int i,int j){
        if(i>j)return;
        int x = partiton(nums,i,j);
        sort(nums,i,x - 1);
        sort(nums,x+1,j);
    }
    public static int partiton(int[] nums,int l,int r){
        int pv = nums[l];
        int i = l;
        int j = r;
        while(i < j){
            while(i < j && nums[j] > pv){//从右往左找比基准点小的
                j--;
            }
            while(i < j && nums[i] <= pv){
                i++;
            }

            swap(nums,i,j);
        }
        swap(nums,l,i);
        return i;
    }
    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    ///改进：随机化
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length - 1);
        return nums;
    }
    public void quickSort(int[] nums,int i,int j){
        if(i >= j)return;
        Random r = new Random();
        swap(nums, i +r.nextInt(j - i + 1), i);
        int x = partition(nums,i,j);
        quickSort(nums,i,x - 1);
        quickSort(nums,x+1,j);
    }
    public int partition(int[] nums,int l,int r){
        int pv = nums[l];
        int i = l;
        int j = r;
        while(i < j){
            while(i < j && nums[j] > pv){
                j--;
            }
            while(i < j && nums[i] <= pv){
                i++;
            }
            swap(nums,i,j);
        }
        swap(nums,l,i);
        return i;
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
