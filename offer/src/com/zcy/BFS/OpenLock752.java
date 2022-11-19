package com.zcy.BFS;

import java.util.*;

public class OpenLock752 {
    public static void main(String[] args) {
       String[] de = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
       String ta = "8888";
        System.out.println(openLock(de,ta));
    }
    //自写通过，长的像坨屎，学习官方封装成方法
    public static int openLock(String[] deadends, String target) {
        Set<String> vis = new HashSet<>();
        Set<String> dead = new HashSet<>();
        for(String s: deadends){
            dead.add(s);
        }
        if(dead.contains("0000")){
            return -1;
        }
        if(target.equals("0000")){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int step = 1;
        while(!queue.isEmpty()){
            for(int j = queue.size();j>0;j--){
                String cur = queue.poll();
                for(int i = 0;i < 4;i++){
                    StringBuilder sb = new StringBuilder(cur);
                    if(cur.charAt(i) == '0'){
                        sb.setCharAt(i,'1');
                        String s1 = sb.toString();
                        if(!vis.contains(s1)&&!dead.contains(s1)){
                            if(s1.equals(target)){
                                return step;
                            }
                            vis.add(s1);
                            queue.offer(s1);
                        }
                        sb.setCharAt(i,'9');
                        String s2 = sb.toString();
                        if(!vis.contains(s2)&&!dead.contains(s2)){
                            if(s2.equals(target)){
                                return step;
                            }
                            vis.add(s2);
                            queue.offer(s2);
                        }
                    }else if(cur.charAt(i) == '9'){
                        sb.setCharAt(i,'0');
                        String s1 = sb.toString();
                        if(!vis.contains(s1)&&!dead.contains(s1)){
                            if(s1.equals(target)){
                                return step;
                            }
                            vis.add(s1);
                            queue.offer(s1);
                        }
                        sb.setCharAt(i,'8');
                        String s2 = sb.toString();
                        if(!vis.contains(s2)&&!dead.contains(s2)){
                            if(s2.equals(target)){
                                return step;
                            }
                            vis.add(s2);
                            queue.offer(s2);
                        }
                    }else{
                        sb.setCharAt(i,(char)(cur.charAt(i) + 1));
                        String s1 = sb.toString();
                        if(!vis.contains(s1)&&!dead.contains(s1)){
                            if(s1.equals(target)){
                                return step;
                            }
                            vis.add(s1);
                            queue.offer(s1);
                        }
                        sb.setCharAt(i,(char)(cur.charAt(i) - 1));
                        String s2 = sb.toString();
                        if(!vis.contains(s2)&&!dead.contains(s2)){
                            if(s2.equals(target)){
                                return step;
                            }
                            vis.add(s2);
                            queue.offer(s2);
                        }

                    }
                }
            }
            step++;
        }
        return -1;
    }
    //**********************官方******************************
    public int openLock666(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> dead = new HashSet<String>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        if (dead.contains("0000")) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer("0000");
        Set<String> seen = new HashSet<String>();
        seen.add("0000");

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String status = queue.poll();
                for (String nextStatus : get(status)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

        return -1;
    }

    public char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }

    // 枚举 status 通过一次旋转得到的数字
    public List<String> get(String status) {
        List<String> ret = new ArrayList<String>();
        char[] array = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }


}
