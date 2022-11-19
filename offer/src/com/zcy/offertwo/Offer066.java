package com.zcy.offertwo;

import java.util.HashMap;

public class Offer066 {
    class Trie{
        int val;
        Trie[] children;
        public Trie(){
            children = new Trie[26];
        }
    }
    Map<String, Integer> map;
    Trie root;
    public MapSum() {
        map = new HashMap<>();
        root = new Trie();
    }

    public void insert(String key, int val) {
        Trie node = root;
        int delta = val - map.getOrDefault(key,0);//拿到变化值。最关键的一步
        map.put(key,val);
        for(int i = 0;i < key.length();i++){
            char ch = key.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
            node.val +=delta;
        }

    }


    public int sum(String prefix) {

        Trie node = root;
        for(int i = 0;i < prefix.length();i++){
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null) return 0;
            node = node.children[index];

        }
        return node.val;
    }


}
