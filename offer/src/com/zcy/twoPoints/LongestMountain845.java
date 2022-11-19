package com.zcy.twoPoints;

public class LongestMountain845 {
    //自写，极度混乱
    //速度可以 2ms
    public int longestMountain(int[] arr) {
        int l = 0,r = 1;
        if(arr.length <=2){
            return 0;
        }
        int len = arr.length;
        int increase = 0;
        int decrease = 0;
        int res = 0;
        while(r < len){
            if(arr[l] == arr[r]){
                if(increase!=0&&decrease !=0){
                    res = Math.max(res,increase+decrease+1);
                }
                increase = 0;
                decrease = 0;
                l++;
                r++;
                continue;
            }
            if(arr[r] > arr[l] && decrease == 0){
                increase++;
                l++;
                r++;
                continue;
            }
            if(arr[r] > arr[l] && decrease !=0){//需要重开了
                res = Math.max(res,increase+decrease+1);
                increase = 1;
                decrease = 0;
                r++;
                l++;
                continue;
            }
            if(arr[r]< arr[l] && increase != 0){//之前正在递增，从现在开始递减
                decrease++;
                l++;
                r++;
                continue;
            }
            if(arr[r] < arr[l] && increase == 0){//要重开
                l++;
                r++;
                continue;
            }
        }
        if(increase!=0 && decrease !=0){
            res = Math.max(res,increase+decrease+1);
        }
        return res;
    }
    //官解牛逼
    //枚举山顶
    public int longestMountain(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int[] left = new int[n];
        for (int i = 1; i < n; ++i) {
            left[i] = arr[i - 1] < arr[i] ? left[i - 1] + 1 : 0;
        }
        int[] right = new int[n];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = arr[i + 1] < arr[i] ? right[i + 1] + 1 : 0;
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] > 0 && right[i] > 0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }

    作者：LeetCode-Solution
    链接：https://leetcode.cn/problems/longest-mountain-in-array/solution/shu-zu-zhong-de-zui-chang-shan-mai-by-leetcode-sol/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
