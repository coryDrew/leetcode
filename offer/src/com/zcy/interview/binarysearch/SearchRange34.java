package com.zcy.interview.binarysearch;

public class SearchRange34 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(",");
        int[] nums = new int[str.length];
        for(int i = 0;i < nums.length;i++){
            nums[i] = Integer.valueOf(str[i]);
        }
        int k = sc.nextInt();
        System.out.print(Arrays.toString(searchRange(nums,k)));
    }


    public static int[] searchRange(int[] nums,int target){
        int[] res = new int[2];
        res[0] = searchFirst(nums,target);
        res[1] = searchLast(nums,target);
        return res;
    }
    public static int searchFirst(int[] nums,int target){
        int l = 0,r = nums.length - 1;
        int res = -1;
        while(l <= r){
            int mid = ((r - l) >> 1) + l;
            if(nums[mid] == target){
                res = mid;
                r =  mid - 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return res;
    }
    public static int searchLast(int[] nums,int target){
        int l = 0,r = nums.length - 1;
        int res = -1;
        while(l <= r){
            int mid = ((r - l) >> 1) + l;
            if(nums[mid] == target){
                res = mid;
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return res;
    }
}
