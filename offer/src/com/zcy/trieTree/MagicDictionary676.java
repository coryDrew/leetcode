package com.zcy.trieTree;

 class MagicDictionary676 {
    //自写，错的，官解用到了dfs
     //下面的是自己写的错的
     public static void main(String[] args) {
         MagicDictionary676 m = new MagicDictionary676();
         m.buildDict(new String[]{"hello","leetcode"});
         System.out.println(m.search("hhllo"));
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
     }
     public Trie node;
     public MagicDictionary676() {
         node = new Trie();
     }

     public void buildDict(String[] dictionary) {
         for(int i = 0;i < dictionary.length;i++){
             node.insert(dictionary[i]);
         }
     }

     public boolean search(String searchWord) {
         //这里必须用newNode,如果直接用node，会把node指向别的对象的，如果多次调用search就会出问题了！！！！！！！！！
         Trie newNode = node;

         for(int i = 0;i < searchWord.length();i++){
             char ch = searchWord.charAt(i);
             int index = ch-'a';
             if(newNode.children[index] == null){


                 for(int j = 0;j < 26;j++){
                     if(newNode.children[j] != null && searchTwice(searchWord.substring(i+1),newNode.children[j])){
                         return true;
                     }
                 }
                 return false;
             }
             newNode = newNode.children[index];
         }
         return false;
     }
     public boolean searchTwice(String word,Trie node){
         for(int i = 0;i < word.length();i++){
             char ch = word.charAt(i);
             int index = ch - 'a';
             if(node.children[index] == null){
                 return false;
             }
             node = node.children[index];
         }
         return true;
     }
}
