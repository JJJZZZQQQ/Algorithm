package codeTop;

import utils.ListNode;

public class 反转链表Ⅱ {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        ListNode next = head.next;
        for (int i = 1; i < right; i++) {
            if (i < left) {
                pre = head;
                head = head.next;
            }
            next = next.next;
        }
        pre.next = reverse(head, right - left);
        head.next = next;
        return dummy.next;
    }

    public ListNode reverse(ListNode head, int n) {
        if (n == 0) return head;
        ListNode newHead = reverse(head.next, n - 1);
        System.out.println(head.val);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
