##208 Implement Trie (Prefix Tree)
# 字典实现  304ms
class Trie(object):
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.is_word = True

    def search_prefix(self, word):
        node = self.root
        for c in word:
            if c not in node.children:
                return None
            node = node.children[c]
        return node

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        node = self.search_prefix(word)
        return node is not None and node.is_word

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        return self.search_prefix(prefix) is not None


class TrieNode(object):
    def __init__(self):
        self.children = {}
        self.is_word = False
