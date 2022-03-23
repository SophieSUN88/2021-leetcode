package Trie;
// 208 Implement Trie (Prefix Tree) :38ms
// Time Complexity: O(len(String word))
// Space Complexity: O(nk)
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c: word.toCharArray()){
            if (node.children[c-'a']==null) 
                node.children[c-'a']=new TrieNode();
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for (char c: word.toCharArray()){
            if (node.children[c-'a']==null) 
                return false;
            node = node.children[c-'a'];
        }
        return node.isWord ;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c: prefix.toCharArray()){
            if (node.children[c-'a']==null) 
                return false;
            node = node.children[c-'a'];
        }
        return true ;
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isWord;
    public TrieNode(){
        children = new TrieNode[26];//长度可以变，目前考虑26字母
    }
}