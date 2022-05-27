package 力扣200题;

public class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        //遍历单词，设置一下next[i]然后到下一层 ,当单词结束时，设置当前节点end 为true
        char[] array = word.toCharArray();
        Node now = root;
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            if(now.next[index] == null) {
                now.next[index] = new Node();
            }
            now = now.next[index];
        }
        now.isEnd = true;
    }

    public boolean search(String word) {
        char[] array = word.toCharArray();
        Node now = root;
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            if(now.next[index] == null) {
                return false;
            }
            now = now.next[index];
        }
        return now.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] array = prefix.toCharArray();
        Node now = root;
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            if(now.next[index] == null) {
                return false;
            }
            now = now.next[index];
        }
        return true;
    }
    class Node {

        //该结点是否是一个串的结束，如果没有这个字段 ，无法区分 前缀相同的字母， 比如 app 和 apple ，不知道到底存在 app 嘛
        boolean isEnd;
        Node [] next ;
        public Node(){
            isEnd = false;
            next = new Node[26];
        }
    }
}
