package codeTop;

import utils.ListNode;

public class 重排链表 {

    public void reorderList(ListNode head) {
        //迭代
        //首先找到链表的中点，中点之后的节点就算后半截
        //然后想办法把后半截插入到前半截
        //可以发现 后半截是倒着一个个插入前半截的间隙的
        if(head == null || head.next == null)return;
        ListNode fast = head , slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode right = slow.next;
        ListNode left = head;
        slow.next = null;
        right = reverse(right);
        while (right != null) {
            ListNode newRight = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = newRight;
        }
    }
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
