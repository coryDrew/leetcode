package com.zcy.string;

public class MyAtoi8 {
    //抄的weiwei，从一开始写的就不够清晰
    //这个问题其实没有考察算法的知识，模拟的是日常开发中对于原始数据的处理（例如「参数校验」等场景），如果面试中遇到类似的问题，应先仔细阅读题目文字说明和示例，有疑惑的地方和需要和面试官确认，在编码的时候需要耐心和细心地调试。
    //
    //其实很多时候，业务需求就是类似这样的问题，工作中如果遇到：
    //
    //1、有现成的工具和类库需尽量使用，因为它们是性能更优，且经过更严格测试，是相对可靠的；
    //2、能抽取成工具类、工具方法的尽量抽取，以突出主干逻辑、方便以后代码复用；
    //3、不得不写得比较繁琐、冗长的时候，需要写清楚注释、体现逻辑层次，以便上线以后排查问题和后续维护。
    //
    //在这里我罗列几个要点：
    //
    //根据示例 1，需要去掉前导空格；
    //根据示例 2，需要判断第 1 个字符为 + 和 - 的情况，因此，可以设计一个变量 sign，初始化的时候为 1，如果遇到 - ，将 sign 修正为 -1；
    //判断是否是数字，可以使用字符的 ASCII 码数值进行比较，即 0 <= c <= '9'；
    //根据示例 3 和示例 4 ，在遇到第 1 个不是数字的字符的情况下，转换停止，退出循环；
    //根据示例 5，如果转换以后的数字超过了 int 类型的范围，需要截取。这里不能将结果 res 变量设计为 long 类型，注意：由于输入的字符串转换以后也有可能超过 long 类型，因此需要在循环内部就判断是否越界，只要越界就退出循环，这样也可以减少不必要的计算；
    //由于涉及下标访问，因此全程需要考虑数组下标是否越界的情况。
    //特别注意：
    //
    //1、由于题目中说「环境只能保存 32 位整数」，因此这里在每一轮循环之前先要检查乘以 1010 以后是否溢出，具体细节请见编码。
    //
    //2、Java 、Python 和 C++ 字符串的设计都是不可变的，即使用 trim() 会产生新的变量，因此我们尽量不使用库函数，使用一个变量 index 去做遍历，这样遍历完成以后就得到转换以后的数值。
    //
    //作者：liweiwei1419
    //链接：https://leetcode.cn/problems/string-to-integer-atoi/solution/jin-liang-bu-shi-yong-ku-han-shu-nai-xin-diao-shi-/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public static int myAtoi(String str) {
        //只有前导的空格是忽略的，后面的空格遍历到就直接退出，不可忽略
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }
            //判断溢出的写法，很有讲究
            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
      String s = "00000-42a1234";
        System.out.println(myAtoi(s));
    }
    public static int myAtoiwrong(String s) {
        if(s.equals("")||s.equals("-")||s.equals("+")){
            return 0;
        }
        String s2 =s.replaceAll(" ","");
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        if(s2.charAt(0) == '-'){
            cnt = -1;
        }
        int index = -1;
        boolean flag1 = false;
        boolean flag2 = false;
        if(s2.charAt(0) =='0'){
            for(int i = 1;i < s2.length();i++){
                if(s2.charAt(i)!='0'){
                    if(s2.charAt(i) =='-'||s2.charAt(i) =='+'){
                        return 0;
                    }else{
                        break;
                    }
                }
            }
        }
        for(int i = 0;i < s2.length();i++){//确定从第几次开始是数字
            if(s2.charAt(i)!='-'&&s2.charAt(i)!='0'&&s2.charAt(i)!='+'){
                index = i;
                break;
            }
            if(s2.charAt(i)=='-'){
                flag1 = true;
            }
            if(s2.charAt(i) =='+'){
                flag2 = true;
            }
            if(flag1&&flag2){
                return 0;
            }
        }
        if(!Character.isDigit(s2.charAt(index))){
            return 0;
        }
        while(index<s2.length()&&Character.isDigit(s2.charAt(index))){
            sb.append(s2.charAt(index));
            index++;
        }
        String ss = new String(sb);
        long res = cnt*Long.valueOf(ss);
        if(res>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(res<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;

        }
        return (int)res;
    }
}
