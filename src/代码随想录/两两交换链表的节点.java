package 代码随想录;

import utils.ListNode;

public class 两两交换链表的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode now = head;
        ListNode pre = dummy;
        // 1 -> 2 - > 3 - > 4 ->5
        //      pre   now       temp
        while (now != null && now.next != null) {
            ListNode temp = now.next.next;
            now.next.next = now;
            pre.next = now.next;
            pre = now;
            now.next = temp;
            now = temp;
        }

        return dummy.next;
    }
}
