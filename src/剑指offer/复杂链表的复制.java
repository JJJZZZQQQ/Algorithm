package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> dic = new HashMap<>();
        Node t = head;
        while (t != null) {
            Node now = new Node(t.val);
            dic.put(t, now);
            t = t.next;
        }
        t = head;
        while (t != null) {
            Node now = dic.get(t);
            now.next = dic.get(t.next);
            now.random = dic.get(t.random);
            t = t.next;
        }
        return dic.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
