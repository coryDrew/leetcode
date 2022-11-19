package com.zcy.binarySearch;

public class UsualBinarySearch {
    //以下都摘自leetbook二分篇

    //1.最基础二分模板①
    public int search(int[] nums, int target) {
        int l = 0,r = nums.length - 1;
        while(l <= r){
            int mid = ((r - l)>>1)+l;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }


    /*2.平方根
    这道题比较烧脑的是要返回right,由于不是完全平方数的数需要向下取整，比如输入8得到的结果是2.
2021.07.30 添加为什么向下取整要返回right的说明。
走到最后return时，说明while循环中没有合乎条件的mid, 跳出循环后left = right + 1; left > right, 向下取整，取小的(right)返回。

作者：Ebisu
链接：https://leetcode.cn/leetbook/read/binary-search/xe9cog/?discussion=oeKufZ
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public int mySqrt(int x) {
        int l = 0,r = x;
        while(l<=r){
            int mid = ((r - l)>>1)+l;
            if((long)mid*mid == x){//防溢出，自己写的，和官方做法一样
                return mid;
            }else if((long)mid*mid > x){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l - 1;//r
    }
    /*3.搜索旋转数组，确定某一边是递增的，注意细节
    * */
    public int searchrotate(int[] nums, int target) {
        if(nums.length == 1){
            return nums[0] == target?0:-1;
        }
        int l = 0,r = nums.length - 1;
        while(l <= r){
            int mid = ((r - l)>>1)+l;
            if(nums[mid] == target){
                while(mid>0&&nums[mid-1] == target){//mid>0一开始忘记加了
                    mid--;
                }
                return mid;
            }else if(nums[mid] >nums[l]){
                if(nums[l] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else if(nums[mid] < nums[l]){
                if(nums[mid]< target&&target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }else{
                l++;
            }

        }
        return -1;
    }
    //4.二分模板②
    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while(left < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid; }
        }

        // Post-processing:
        // End Condition: left == right
        if(left != nums.length && nums[left] == target) return left;
        return -1;
    }
    //5.第一个错误的版本
    //用模板①②都可以
    public int firstBadVersion(int n) {
        int l = 1,r = n;
        while(l<r){
            int mid = ((r - l)>>1)+l;
            if(isBadVersion(mid)){//题目自带的函数
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    //6.寻找峰值
    //①②都可以
    public int findPeakElement(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]>nums[mid+1]){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    //7.旋转数组的最小值
    //以high为基准，挺难想的，个人觉得，而且要画图
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
    //8.二分模板③
    //同只会1和2， 感觉3用不上。
    //while(l<=r)
    //适用于中间会产生结果，比如求平方根，中间每一步都是结果，最后l>r之前的一步结果为最后结果
    //while(l<r)
    //适用于夹逼出唯一一个结果，如果求峰值，峰值一定存在，那么只要夹逼出l=r的情况就是结果。
    //
    //作者：Gavin
    //链接：https://leetcode.cn/leetbook/read/binary-search/xewjg7/?discussion=mzALQU
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    int binarySearchThree(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while (left + 1 < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // Post-processing:
        // End Condition: left + 1 == right
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }
    //9.快速幂，其实不算二分，是分治思想
    //快速幂+递归，直接求得一半的幂的值，然后根据奇偶数判断最终的处理
    public double myPow(double x, int n) {
        long N = n;
        return N>0?quickMul(x,N):1/quickMul(x,-N);

    }
    public double quickMul(double x,long N){
        if(N == 0){
            return 1;
        }
        double y = quickMul(x,N/2);//求得一半的幂 如果N是77这里求的就是38，y就是x的38次方
        return N%2 == 0 ? y*y:y*y*x;//如果N是偶数，就两个y乘就行了；如果N是77，上面求的是x的38次方，两个y就是x的76次方，所以还要再乘一个x
    }
    //10.判断是否是完全平方数
    //和上面的求平方根基本一样的
    public boolean isPerfectSquare(int num) {
        int l = 0,r = num;
        while(l <= r){
            int mid = ((r - l)>>1)+l;
            if((long)mid*mid == num){
                return true;
            }else if((long)mid*mid >num){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}
