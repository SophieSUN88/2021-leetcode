# Trie
- or named Prefix Tree.
- Trie is like a N-array Tree.

## Property
    - root does not contain any char
    - other node contains 1 char per each
    - from root node to termial node, all chars linked together to be a string
    - the children of any node cantain different char 任意节点的所有子节点所包含的字符都不相同

## Use cases
- google search 自动不全功能
- 拼写检查
- IP路由
- T9 九宫格打字预测
- 词频统计， 用trie树来压缩空间，因为功能前缀都是用一个节点保存的

## 模板
- addWord (string word)
- search (string word)
- searchPrefix (string prefix)