package 剑指offer;

import java.util.HashMap;

public class LRUCache {
    class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    class DoubleList {

        private Node head, tail;
        private int size;

        public void addFirst(Node node) {
            //添加注意链表为空的情况
            if (head == null) {
                head = tail = node;
            } else {
                head.prev = node;
                node.next = head;
                head = node;
            }
            size++;
        }
        /**
         * 由于删除节点有可能会删除掉头节点和尾节点，所以我们在删除的时候需要考虑是否为头节点和尾节点的情况
         */
        public void remove(Node node) {
            //只有一个节点
            if (head == node && tail == node) {
                head = null;
                tail = null;
            } else if (tail == node) {
                //删除的节点是尾节点
                node.prev.next = null;
                tail = node.prev;
            } else if (head == node) {
                //删除的节点是头节点
                node.next.prev = null;
                head = node.next;
            } else {
                //普通节点
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }

        public Node removeLast() {
            Node node = tail;
            remove(tail);
            return node;
        }

        public int size() {
            return size;
        }
    }
    //map里面直接放node，便于删除
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        put(key, val);
        return val;
    }
    //如果存在，将链表旧的remove，再把新的放进去
    //如果不存在，判断是否需要淘汰末位，再把新的放进去
    public void put(int key, int value) {
        Node x = new Node(key, value);

        if (map.containsKey(key)){
            cache.remove(map.get(key));
        } else {
            if (cap == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
        cache.addFirst(x);
        map.put(key,x);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */