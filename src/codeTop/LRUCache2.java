package codeTop;

import utils.ListNode;

import java.util.HashMap;
import java.util.List;

/**
 * 使用双向链表手动实现
 * 双向链表需要的操作
 * 1.删除一个指定的结点
 * 2.删除头节点
 * 3.在头部添加结点
 */
public class LRUCache2 {

    class Node {
        public Node pre;
        public Node next;
        public int key;
        public int val;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

}
