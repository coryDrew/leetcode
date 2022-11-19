package com.zcy.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetImportance690 {
    //自写dfs
    //两个map，一个存重要度，一个存她的直接下属
    Map<Integer,Integer> imp;
    Map<Integer, List<Integer>> sub;
    List<Integer> list = new ArrayList<>();
    public int getImportance(List<Employee> employees, int id) {
        imp = new HashMap<>();
        sub = new HashMap<>();
        for(Employee employee: employees){
            imp.put(employee.id,employee.importance);
            sub.put(employee.id,employee.subordinates);
        }
        dfs(sub,id);
        int res = imp.get(id);
        for(int s:list){
            res+=imp.get(s);
        }
        return res;
    }
    public void dfs(Map<Integer,List<Integer>> subMap,int id){
        List<Integer> mysub = subMap.get(id);
        if(mysub == null){
            return;
        }
        for(int s:mysub){
            list.add(s);
            dfs(subMap,s);
        }
    }//找到id对应员工的全部下属
}
