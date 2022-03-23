// 211 Design Add and Search Words Data Structure
// 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

// 实现词典类 WordDictionary ：

// WordDictionary() 初始化词典对象
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
//  

// 示例：

// 输入：
// ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
// [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
// 输出：
// [null,null,null,null,false,true,true,true]

// 解释：
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("bad");
// wordDictionary.addWord("dad");
// wordDictionary.addWord("mad");
// wordDictionary.search("pad"); // return False
// wordDictionary.search("bad"); // return True
// wordDictionary.search(".ad"); // return True
// wordDictionary.search("b.."); // return True

public class Trie_dot {
    TrieNode root = new TrieNode();
    public void addWord(String word){
        TrieNode node = root;
        for (char ch:word.toCharArray()){
            if (node.children[ch-'a']==null)
                node.children[ch-'a'] = new TrieNode();
            node = node.children[ch-'a'];
        }
        node.isWord = true;
    }
    // Returns if the word is in the data structure. 
    // A word could contain the dot character '.' to represent any one letter.
    public boolean search(String word){
        return helper(word,0,root);
    }
    public boolean helper(String word, int pos, TrieNode node){
        if (pos == word.length()) return node.isWord;
        char ch = word.charAt(pos);
        if (ch != '.') 
            return node.children[ch-'a'] !=null && helper(word,pos+1,node.children[ch-'a']);
        for (int i=0;i<26;i++)
            if (node.children[i]!=null && helper(word,pos+1,node.children[i]))
                return true;
        return false;
    }
}

class TrieNode{
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
}
