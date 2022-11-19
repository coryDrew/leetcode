package com.zcy.trieTree;

public class WordDictionary211 {
    //可做模板
    public Trie root;
    public WordDictionary211() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }
    public boolean dfs(String word, int index, Trie node){
        if(index == word.length()){
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if(Character.isLetter(ch)){
            int childIndex = ch - 'a';
            Trie child = node.getChildren()[childIndex];
            if(child != null && dfs(word,index+1,child)){
                return true;
            }
        }else{
            for(int i = 0;i < 26;i++){
                Trie child = node.getChildren()[i];
                if(child != null && dfs(word,index+1,child)){
                    return true;
                }
            }
        }
        return false;
    }
}
class Tire{
    //可做tire树模板
    private Trie[] children;
    private Boolean isEnd;
    public Tire(){
        children = new Trie[26];
        isEnd = false;
    }
    public void insert(String word){
        Trie node = this;
        for(int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            int index = ch -'a';
            if(node.getChildren()[index] == null){
                node.getChildren()[index] = new Trie();
            }
            node = node.getChildren()[index];
        }
        node.isEnd = true;
    }
    public Trie[] getChildren(){
        return children;
    }
    public boolean isEnd(){
        return isEnd;
    }

}
