package 剑指offer;

import utils.ListNode;

public class 普通链表的复制 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode newHead = new ListNode(head.val);
        ListNode pre = newHead;
        ListNode now = head;
        now = now.next;
        while (now != null) {
            ListNode nowCopyNode = new ListNode();
            nowCopyNode.val = now.val;
            pre.next = nowCopyNode;
            pre = nowCopyNode;
            now = now.next;
        }
    }
}
