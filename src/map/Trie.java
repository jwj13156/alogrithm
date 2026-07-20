package map;

class Trie {
    // 根节点（空节点，不存字符）
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 插入单词 word
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            // 当前字母不存在，新建节点
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode();
            }
            // 移动到子节点
            cur = cur.children[idx];
        }
        // 单词最后一个字符节点标记为单词结尾
        cur.isEnd = true;
    }

    // 精确查找完整单词，必须是完整存在的单词
    public boolean search(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            // 中途字符不存在，直接匹配失败
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        // 全部字符走完，必须当前节点是单词末尾才返回true
        return cur.isEnd;
    }

    // 判断是否存在以 prefix 为前缀的单词
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) {
                return false;
            }
            cur = cur.children[idx];
        }
        // 只要前缀路径全部存在即可，不需要是单词结尾
        return true;
    }
}
class TrieNode {
    // 26个小写字母
    TrieNode[] children;
    // 是否是单词末尾
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}