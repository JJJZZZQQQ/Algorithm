import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    DoubleList doubleList;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        doubleList = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        int val = node.val;
        put(node.key, node.val);
        return val;
    }

    public void put(int key, int value) {

        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            //如果存在，把原来的删除之后再add
            doubleList.remove(map.get(key));
            map.remove(key);
        }


        map.put(key, node);
        doubleList.add(node);
        //判断是否超出容量

        if(doubleList.size > capacity) {
            Node last = doubleList.removeLast();
            map.remove(last.key);
        }
    }


    class DoubleList {
        int size = 0;
        Node head;
        Node tail;

        void remove(Node node) {
            if(node == head && node == tail) {
                head = tail = null;
            }
            else if(head == node) {
                head.next.pre = null;
                head = head.next;
            } else if(tail == node) {
                tail.pre.next = null;
                tail = tail.pre;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            size--;
        }

        void add(Node node) {
            if(head == null && tail == null) {
                head = tail = node;
            } else {
                node.next = head;
                head.pre = node;
                head = node;
            }
            size++;
        }

        Node removeLast() {
            Node t = tail;
            remove(tail);
            return t;
        }
    }

    class Node {
        Integer key;
        Integer val;
        Node next;
        Node pre;
        public Node(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }
    }
}
