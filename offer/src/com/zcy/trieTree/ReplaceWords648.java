package com.zcy.trieTree;

import java.util.List;

public class ReplaceWords648 {
    //简单字典树
    //对于每个单词，查字典中是否有该单词的前缀，一旦找到isEnd为true的，直接返回当前遍历到的字符串
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie node = new Trie();
        for(int i = 0;i < dictionary.size();i++){
            node.insert(dictionary.get(i));
        }
        String[] str = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < str.length;i++){
            sb.append(node.shortPre(str[i])+" ");
        }
        return sb.toString().trim();
    }
    class Trie{
        public Trie[] children;
        public boolean isEnd;
        public Trie(){
            children = new Trie[26];
            isEnd = false;
        }
        public void insert(String word){
            Trie node = this;
            for(int i = 0;i < word.length();i++){
                char ch = word.charAt(i);
                int index = ch - 'a';
                if(node.children[index] == null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
        public String shortPre(String word){
            StringBuilder sb = new StringBuilder();
            Trie node = this;
            for(int i = 0;i < word.length();i++){
                char ch = word.charAt(i);
                int index = ch - 'a';
                if(node.children[index] == null){
                    return word;
                }else{
                    sb.append(ch+"");
                }
                if(node.children[index].isEnd){
                    return sb.toString();
                }
                node = node.children[index];
            }
            return word;
        }
    }
}
