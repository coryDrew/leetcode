package com.zcy.wcd85;

public class ShiftingLetters6158 {
    /**
     前缀和主要适用的场景是原始数组不会被修改的情况下，频繁查询某个区间的累加和

     差分数组的主要适用场景是频繁对原始数组的某个区间的元素进行增减

     使用场景：对于一个数组 nums[]

     要求一：对 num[2...4] 全部 + 1
     要求二：对 num[1...3] 全部 - 3
     要求三：对 num[0...4] 全部 + 9
     看到上述情景，首先想到的肯定是遍历（bao li）。直接对数组循环 3 遍，每次在规定的区间上按要求进行操作，此时时间复杂度 O(3n)

     但是当这样的操作变得频繁后，时间复杂度也呈线性递增

     所以针对这种场景，提出了「差分数组」的概念，举个简单的例子



     diff[] 和 nums[] 的关系：diff[i] = nums[i] - nums[i - 1]，diff[0] 除外

     问题一：这样处理的好处是什么呢？？？？？

     当我们需要对 nums[] 进行上述三个要求时，不需要一次一次的遍历整个数组了，而只需要对 diff[] 进行一次 O(1) 的操作即可

     要求一：diff[2] += 1;
     要求二：diff[1] += (-3); diff[3 + 1] -= (-3);
     要求三：diff[0] += 9;
     总结：对于改变区间 [i, j] 的值，只需要进行如下操作 diff[i] += val; diff[j + 1] -= val

     作者：lfool
     链接：https://leetcode.cn/problems/shifting-letters-ii/solution/by-lfool-ipl4/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 */
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int m=shifts.length;
        //初始化差分数组
        int [] diff=new int [n+1];//代表前一个和当前的差距，用n+1是为了防止后面end+1越界
        diff[0]=s.charAt(0)-'a';//第一个位置不用和和前面比，记录值即可
        int init=diff[0];
        for(int i=1;i<n;i++){
            int cur=s.charAt(i)-'a';//当前值
            diff[i]=cur-init;//和前一个位置比较，求出差值放到diff中
            init=cur;
        }
        //差分数组区间操作
        for(int i=0;i<m;i++){
            int start=shifts[i][0];
            int end=shifts[i][1];
            int dir=shifts[i][2]==1?1:-1;
            diff[start]+=dir;//差分数组的操作就是这两步
            diff[end+1]-=dir;
        }
        StringBuilder sb=new StringBuilder();
        int pre=0;
        for(int i=0;i<n;i++){
            pre+=diff[i];//一个一个恢复数据，恢复出来的数就是和‘a’的差距
            if(pre<0){//负的变成正的
                while(pre<0){
                    pre+=26;
                }
            }
            else pre%=26;//避免超过26导致循环移动
            char c=(char)(pre+'a');
            sb.append(c);
        }
        return sb.toString();
    }
}
