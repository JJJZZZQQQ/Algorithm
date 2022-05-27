package codeTop;

import utils.ListNode;

public class K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //每K个就翻转一次
        //走k次，找到下一次翻转的头节点
        //那么这个结点的上一个结点就是这次翻转的末尾结点
        //还要一个结点记录这次翻转的结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = dummy;
        ListNode pre = dummy;
        while (end != null) {
            ListNode start = pre.next;
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode next = end.next;
            //控制翻转链表的位置
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            //重置各个变量
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
