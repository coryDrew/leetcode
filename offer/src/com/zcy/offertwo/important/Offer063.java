package com.zcy.offertwo.important;

import java.util.List;

public class Offer063 {
    //简单前缀树
    class Trie{
        boolean isEnd;
        Trie[] children;
        public Trie(){
            isEnd = false;
            children = new Trie[26];
        }
    }
    Trie root = new Trie();
    public void insert(String word){
        Trie node = root;
        for(int i =0;i < word.length();i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    public String findLeast(String word){
        Trie node = root;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index] == null){
                return "";
            }
            sb.append(ch);
            node = node.children[index];
            if(node.isEnd){
                return new String(sb);
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for(int i = 0;i < dictionary.size();i++){
            insert(dictionary.get(i));
        }
        String[] strs = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = 0;i < strs.length;i++){
            String ret = findLeast(strs[i]);
            if(ret == ""){
                res.append(strs[i]);
            }else{
                res.append(ret);
            }
            res.append(" ");
        }
        return res.toString().trim();

    }
}
