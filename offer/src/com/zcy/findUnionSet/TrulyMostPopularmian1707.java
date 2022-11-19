package com.zcy.findUnionSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrulyMostPopularmian1707 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        UnionFind uf = new UnionFind();
        for(String str:names){
            //遍历names进行初始化
            int index1 = str.indexOf('('),index2 = str.indexOf(')');
            String name = str.substring(0,index1);
            int count = Integer.valueOf(str.substring(index1+1,index2));
            uf.parent.put(name,name);
            uf.size.put(name,count);
        }
        for(String synonym:synonyms){
            int index = synonym.indexOf(',');
            String name1 = synonym.substring(1,index);
            String name2 = synonym.substring(index+1,synonym.length() - 1);
            //避免漏网之鱼
            if(!uf.parent.containsKey(name1)) {
                uf.parent.put(name1, name1);
                //注意人数为0
                uf.size.put(name1, 0);
            }
            if(!uf.parent.containsKey(name2)) {
                uf.parent.put(name2, name2);
                uf.size.put(name2, 0);
            }
            uf.union(name1, name2);
        }
        List<String> res = new ArrayList<>();
        for(String str:names){
            int index1 = str.indexOf('('), index2 = str.indexOf(')');
            String name = str.substring(0, index1);
            //判断是不是大爹
            if(uf.parent.get(name).equals(name)){
                res.add(name+"("+uf.size.get(name)+")");
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
class UnionFind{
    //爹集
    Map<String,String> parent;
    //该节点出现次数
    Map<String,Integer> size;
    public UnionFind(){
        this.parent = new HashMap<>();
        this.size = new HashMap<>();
    }
    //找爹函数
    public String find(String x){
        if(parent.get(x).equals(x)){
            return x;
        }
        //路径压缩
        parent.put(x,find(parent.get(x)));
        return parent.get(x);
    }
    public void union(String x,String y){
        String p1 = find(x),p2 = find(y);
        if(p1.equals(p2)){
            return;
        }
        //字典序小的作为根
        if(p1.compareTo(p2) > 0) {
            parent.put(p1, p2);
            //人数累加到根节点
            size.put(p2, size.get(p1) + size.get(p2));
        }else {
            parent.put(p2, p1);
            size.put(p1, size.get(p2) + size.get(p1));
        }
    }
}
