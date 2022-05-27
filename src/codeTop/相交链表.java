package codeTop;

import utils.ListNode;

public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA, t2 = headB;
        while (t1 != t2) {
            //不能这样，这也 t1 和 t2 不会为null ，对于 没有相交结点的永远出不来
            //t1 = t1.next == null ? headB : t1.next;
            // t2 = t2.next == null ? headA : t2.next;
            t1 = t1 == null ? headB : t1.next;
            t2 = t2 == null ? headA : t2.next;
        }
        return t1;
    }
}
