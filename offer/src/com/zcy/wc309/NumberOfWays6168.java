package com.zcy.wc309;

public class NumberOfWays6168 {
    //溢出问题,为什么是负的呢？ 想不明白，是long也溢出了？实验说明确实是long溢出
    //int最大21亿，long是19位
    //(a + b) % p = (a % p + b % p) % p 这样可以避免溢出，关键公式！！！！
    //a直接加b就溢出了
    public static void main(String[] args){
        System.out.println(numberOfWays(989,1000,99));
    }
    static long[][] help;
    public static int numberOfWays(int startPos, int endPos, int k) {
        help = new long[1000][1000];//i代表距离，j代表有多少步
        for(int i = 0;i < 1000;i++){
            for(int j = 0;j < 1000;j++){
                help[i][j] = -1L;
            }
        }
        return (int)(ways(startPos,endPos,k)%1000000007);
    }
    public static long ways(int start,int end,int k){
        if(help[Math.abs(end - start)][k] != -1L) return help[Math.abs(end - start)][k];
        if(end - start == k) return 1L;
        if(start == end && k == 0) return 1L;
        if(start != end && k == 0) return 0L;
        //help[Math.abs(end - start)][k] = ways(start +1,end,k - 1)%1000000007 + ways(start - 1,end,k - 1)%1000000007;
        //help[Math.abs(end - start)][k] = ways(start +1,end,k - 1) + ways(start - 1,end,k - 1);
        //为什么这里两个都要mod，不mod最后结果是负的,因为直接加起来long也溢出了，可怕
        //测试
        help[Math.abs(end - start)][k] = ways(start +1,end,k - 1) + ways(start - 1,end,k - 1);
        System.out.println( ways(start +1,end,k - 1));
        System.out.println( ways(start -1,end,k - 1));//可以看到已经超出了long的范围，long是19位
        //难道是因为不mod会导致long也溢出？如何测试

        return help[Math.abs(end - start)][k];
    }
}
/*  HashMap<String, Long> cache = new HashMap<>();

    public int numberOfWays(int startPos, int endPos, int k) {
        return (int) (dfs(startPos, endPos, k) % 1000000007);
    }

    Long dfs(int curIndex, int end, int k) {
        if (curIndex == end && k == 0) {
            return 1L;
        }
        if (k == 0) {
            return 0L;
        }
        //不可能走到，及时退出
        if(Math.abs(end-curIndex)>k){
            return 0L;
        }
        String state = curIndex + "," + k;
        if (cache.containsKey(state)) {
            return cache.get(state);
        }
        long ans = 0;
        ans = (ans + dfs(curIndex - 1, end, k - 1)) % 1000000007;
        ans = (ans + dfs(curIndex + 1, end, k - 1)) % 1000000007;
        cache.put(state, ans);
        return ans;
    }

作者：not-a-hero
链接：https://leetcode.cn/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/solution/ji-yi-hua-sou-suo-by-not-a-hero-lrv6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
* */
