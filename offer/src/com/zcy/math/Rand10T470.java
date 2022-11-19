package com.zcy.math;

public class Rand10T470 {
    /**
     拒绝采样
     左神讲过
     算法描述
     我们希望通过某个事件发生器获得等概率事件，例如 Rand7()Rand7() 是一个随机数生成器，以相等的概率随机生成 1 \sim 71∼7 。 拒绝采样的意思是，如果这个事件发生器能够产生的独立事件种类数多于我们所需，我们可以设置条件舍弃一部分事件。例如我们希望利用 Rand7()Rand7() 获取概率各为 50\%50% 的两个独立事件，那么我们可以在得到 77 时拒绝掉该事件，而获得 1,3,51,3,5 视作同一个事件，2,4,62,4,6 视作另一个事件，由于他们在 77 以外的事件中各占一半，因此这两个事件发生概率都是 50\%50% (\frac{3}{7}/(\frac{3}{7}+\frac{3}{7})=\frac{1}{2}
     7
     3
     ​
     /(
     7
     3
     ​
     +
     7
     3
     ​
     )=
     2
     1
     ​
     )。

     对应到本题，只要我们能够用 Rand7()Rand7() 设计出 1010 种等概率事件即可。采用古典概型，以上述例子为概率各 50\%50% 的事件，再以拒绝 6,76,7 后得到的 11 到 55 为概率均为 20\%20% 的事件，二者相结合即可产生十种不同的概率均为 10\%10% 的独立事件。
     */
    public int rand10() {
        int a = 7;
        int b = 7;
        while(a == 7) a = rand7();//rand7是题目自带
        while(b == 6 || b == 7) b = rand7();
        return a%2 == 0? b: 5+b;
    }
}