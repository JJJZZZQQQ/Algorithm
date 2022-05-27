package codeTop;

import utils.ListNode;

public class 链表中倒数第k个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        //直接快慢指针完事
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
