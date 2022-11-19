package com.zcy.trieTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Searchmian1717 {
    /*好像用 trie 的题目都是一模一样的场景：给你一个长句子，再给你一堆“敏感词”，然后让你找敏感词在句子里的位置（因为要把敏感词换成 ***）。

把敏感词 smalls 的数量记为 t，把敏感词里最长的字符串长度记为 k，把长句子 big 的长度记为 b。

具体步骤：

1）把这堆敏感词建成一颗 Trie 树，时间复杂度是 O(tk)。

2）遍历长句子的每一个字母，检查“以该字母作为起点”的话，是否可以在 trie 中找到结果。时间复杂度是 O(bk)

综上，总的时间复杂度是 O(tk + bk)。在这种题目场景下这种 trie 的思路应该就是时间复杂度最好的答案了。
   */
    //写了两个内部类，没必要吧
    class Trie{
        TrieNode root;
        public Trie(String[] words){
            root = new TrieNode();
            for(String word : words){
                TrieNode node = root;
                for(char w : word.toCharArray()){
                    int i = w - 'a';
                    if(node.next[i] == null){
                        node.next[i] = new TrieNode();
                    }
                    node = node.next[i];
                }
                node.end = word;//代表这个点是word的结尾
            }
        }

        public List<String> search(String str){
            TrieNode node = root;
            List<String> res = new ArrayList<>();
            for(char c : str.toCharArray()){
                int i = c - 'a';
                if(node.next[i] == null){
                    break;
                }
                node = node.next[i];
                if(node.end != null){
                    res.add(node.end);
                }
            }
            return res;
        }
    }

    class TrieNode{
        String end;
        TrieNode[] next = new TrieNode[26];
    }


    public int[][] multiSearch(String big, String[] smalls) {
        Trie trie = new Trie(smalls);
        Map<String, List<Integer>> hit = new HashMap<>();
        for(int i = 0; i < big.length(); i++){
            List<String> matchs = trie.search(big.substring(i));//看big每个索引为开始的字符串能不能遍历到要求的小字符串
            for(String word: matchs){
                if(!hit.containsKey(word)){
                    hit.put(word, new ArrayList<>());
                }
                hit.get(word).add(i);
            }
        }

        int[][] res = new int[smalls.length][];
        for(int i = 0; i < smalls.length; i++){
            List<Integer> list = hit.get(smalls[i]);
            if(list == null){
                res[i] = new int[0];
                continue;
            }
            int size = list.size();
            res[i] = new int[size];
            for(int j = 0; j < size; j++){
                res[i][j] = list.get(j);
            }
        }
        return res;
    }
}
