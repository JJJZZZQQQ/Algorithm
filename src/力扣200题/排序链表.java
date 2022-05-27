package 力扣200题;

import utils.ListNode;

public class 排序链表 {

    //要满足题目条件，那么就只能归并了
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;
        //归并
        //找到中点
        ListNode left = head;
        ListNode right = head;
        ListNode pre = null;
        while (right != null && right.next != null) {
            pre = left;
            right = right.next.next;
            left = left.next;
        }
        pre.next = null;
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(left);
        return merge(leftNode , rightNode);
    }
    //合并两个,并返回头节点
    public ListNode merge(ListNode l1 , ListNode l2) {
        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        ListNode now = newHead;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                now.next = l1;
                l1 = l1.next;
            } else {
                now.next = l2;
                l2 = l2.next;
            }
            now = now.next;
        }
        now.next = l1 == null ? l2 : l1;
        return newHead.next;
    }

}
