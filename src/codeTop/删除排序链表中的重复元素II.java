package codeTop;

import utils.ListNode;

public class 删除排序链表中的重复元素II {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1000);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val != cur.val) {
                pre = cur;
                cur = cur.next;
            } else {
                int x = cur.val;
                while (cur != null && cur.val == x) {
                    cur = cur.next;
                }
                pre.next = cur;
            }
        }
        return dummy.next;
    }
}
