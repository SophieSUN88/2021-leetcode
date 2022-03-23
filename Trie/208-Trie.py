##208 Implement Trie (Prefix Tree)
## 标准实现 360ms
class Trie(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        node = self.root
        for i in range(len(word)):
            if not node.containsKey(word[i]):
                node.put(word[i], TrieNode())
            node = node.get(word[i])
        node.isEnd = True

    def searchPrefix(self, word):
        node = self.root
        for i in range(len(word)):
            if node.containsKey(word[i]):
                node = node.get(word[i])
            else:
                return None
        return node

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        node = self.searchPrefix(word)
        return node is not None and node.isEnd

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        node = self.searchPrefix(prefix)
        return node is not None


class TrieNode:
    def __init__(self):
        self.__R = 26
        self.isEnd = False
        self.links = [None] * self.__R

    def containsKey(self, ch):
        return self.links[ord(ch) - ord('a')] is not None

    def get(self, ch):
        return self.links[ord(ch) - ord('a')]

    def put(self, ch, node):
        self.links[ord(ch) - ord('a')] = node
