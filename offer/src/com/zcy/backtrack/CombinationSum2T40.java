package com.zcy.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2T40 {
    //注意这题的去重和全排列去重的区别！！之前以为一样的，在草稿纸上画流程就能分析出来
    /**
     同一层数值相同的结点第 22、33 ... 个结点，因为数值相同的第 11 个结点已经搜索出了包含了这个数值的全部结果，同一层的其它结点，候选数的个数更少，搜索出的结果一定不会比第 11 个结点更多，并且是第 11 个结点的子集。

     作者：liweiwei1419
     链接：https://leetcode.cn/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtrack(candidates,new ArrayList<>(),0,target, 0);
        return res;
    }
    public void backtrack(int[] candidates,List<Integer> list,int start,int target,int sum){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i < candidates.length;i++){
            if(i > start && candidates[i] == candidates[i-1]) continue;

            sum+=candidates[i];
            if(sum<=target){
                list.add(candidates[i]);
                backtrack(candidates,list,i+1,target,sum);
                list.remove(list.size()-1);
                sum-=candidates[i];
            }else{
                break;
            }



        }
    }
}
