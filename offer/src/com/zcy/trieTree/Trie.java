package com.zcy.trieTree;

public class Trie {
    //一个节点就代表一个字母
    //搜索是否有word的方法（内部调用搜索是否有word为前缀的方法）
    //搜索是否有以word为前缀的方法
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    //实际应用的时候这些方法不一定要写在Trie类里面！
    public void insert(String word) {
        Trie node = this;//操作前都要有着一句！！，防止当前对象的指向变了！！！
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {//其他方法都依靠这个方法实现
        Trie node = this;//必须加
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
