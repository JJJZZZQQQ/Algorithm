package 代码随想录;

import utils.ListNode;

public class 链表相交 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode boy = headA;
        ListNode girl = headB;
        while (boy != girl) {
            boy = boy == null ? headB : boy.next;
            girl = girl == null ? headA : girl.next;
        }
        return boy;
    }
}
