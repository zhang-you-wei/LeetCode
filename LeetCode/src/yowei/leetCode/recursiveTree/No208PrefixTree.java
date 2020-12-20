package yowei.leetCode.recursiveTree;

/**
 * 前缀树（单词查找树）
 * 每个节点都有26个分支，使用长度为26的数组标记，并标记是否为叶子节点
 * 二叉树的左右孩子命名为left,right,而单词树的26个孩子就分别命名为啊a,b,c……
 */
public class No208PrefixTree {
    class TrieNode {
        //thisNode表示该节点本身
        private TrieNode[] thisNode;

        private int R = 26;

        private boolean isEnd;

        public TrieNode() {
            thisNode = new TrieNode[R];
        }

        public boolean containsKey(char ch) {           //等同于tree.left != null;
            return thisNode[ch -'a'] != null;
        }
        public TrieNode get(char ch) {                  //等同于return tree.left;
            return thisNode[ch -'a'];
        }
        public void put(char ch, TrieNode node) {         //等同于tree.left = nextTree;
            thisNode[ch -'a'] = node;
        }
        public void setEnd() {
            isEnd = true;
        }           //标记为叶子节点
        public boolean isEnd() {
            return isEnd;
        }
    }

    private TrieNode root;

    public No208PrefixTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            //如果不包含该字母分支就创建
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            //包含则继续向后遍历
            node = node.get(currentChar);
        }
        node.setEnd();              //添加结束，将最后遍历到的节点设为叶子节点
    }


    //沿着树向下查找
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;            //没有查到时直接返回
            }
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }


    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
