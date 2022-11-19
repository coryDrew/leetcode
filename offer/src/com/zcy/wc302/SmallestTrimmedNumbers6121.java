package com.zcy.wc302;

import com.sun.corba.se.impl.presentation.rmi.IDLNameTranslatorImpl;

import java.util.Arrays;
import java.util.Comparator;

public class SmallestTrimmedNumbers6121 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,6,4};
        //Arrays.sort(nums,(o1,o2)->(o2 - o1));错误

       // Arrays.sort(nums,new Comparator<Integer>(){也错误，就是上面的完全体


         //   @Override
        //    public int compare(Integer o1, Integer o2) {
         //       return 0;
         //   }
       // });
        //只能下面这样   吗？
        int[] numsclone = new int[nums.length];
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            numsclone[i] = nums[nums.length - i - 1];
        }

    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries)
    {

        int nn = nums.length;
        int m = nums[0].length();
        int qn = queries.length;

        Integer [] idxs = new Integer[nn];//Integer才能用比较器！！！！
        for (int i = 0; i < nn; i ++)//下标数组，记录所有的下标，后面排序用，妙啊
        {
            idxs[i] = i;
        }

        int [] res = new int[qn];

        String [] tmp = new String[nn];
        for (int qi = 0; qi < qn; qi ++)
        {
            int k = queries[qi][0],    rLen = queries[qi][1];
            for (int i = 0; i < nn; i ++)
            {
                String num = nums[i];
                String x = num.substring(m - rLen, m);
                tmp[i] = x;
            }
            Arrays.sort(idxs, new Comparator<Integer>(){
                @Override
                public int compare(Integer i, Integer j) {//根据每个下标对应的tmp值进行排序，对应值小的下标排在前面，符合题目要求
                    if (tmp[i].equals(tmp[j]) == false)
                    {
                        return tmp[i].compareTo(tmp[j]);
                    }
                    else
                    {
                        return i - j;
                    }
                }


            } );
            res[qi] = idxs[k - 1];
        }

        return res;
    }
}
