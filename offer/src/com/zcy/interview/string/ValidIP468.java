package com.zcy.interview.string;

public class ValidIP468 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.print(validIP(s));
    }

    public static String validIP(String s){
        return isIPv4(s)?"IPv4":isIPv6(s)?"IPv6":"neither";

    }
    public static boolean isIPv4(String s){
        //1、根据"."分割开；2、四段；3、每段0-255；4、无前导0；5、全是digit
        String t[]=s.split("\\.");//切.时，要加转义字符！！又忘了！
        if(t.length!=4){return false;}
        for(int i=0;i<4;i++){
            //判断长度单个元素的长度是否符合，以及是否有前导零
            if(t[i].length()==0||t[i].length()>3||t[i].length()>1&&t[i].charAt(0)=='0'){return false;}
            int sum=0;
            for(char c:t[i].toCharArray()){
                if(!Character.isDigit(c)){return false;}//判断是否是字母
                sum=sum*10+c-'0';
            }
            if(sum>255){return false;}
        }
        return true;
    }
    public static boolean isIPv6(String s){
        //1、根据":"分隔开；2、八段；3、1-4位；4、字母(abcdef)或者数字
        s=s.toLowerCase();
        String t[]=s.split(":");
        if(t.length!=8){return false;}
        for(int i=0;i<8;i++){
            if(t[i].length()==0||t[i].length()>4){return false;}
            for(char c:t[i].toCharArray()){if(!(c>='0'&&c<='9')&&!(c>='a'&&c<='f')){return false;}}
        }
        return true;
    }
}
