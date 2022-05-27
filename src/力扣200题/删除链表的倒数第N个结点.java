package 力扣200题;

import utils.ListNode;

public class 删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast != null ) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = pre.next.next;
        //有可能头节点被删了
        return dummy.next;
    }
}
