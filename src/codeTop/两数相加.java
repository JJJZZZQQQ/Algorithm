package codeTop;

import utils.ListNode;

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode head = l1;
        ListNode pre = null;
        while (l1 != null && l2 != null) {
            int t = l1.val + l2.val + jinwei;
            l1.val = t % 10;
            jinwei = t / 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l2 != null) {
            pre.next = l2;
            while (l2 != null) {
                int t = l2.val + jinwei;
                l2.val = t % 10;
                jinwei = t / 10;
                pre = l2;
                l2 = l2.next;
            }
        } else {
            while (jinwei != 0 && l1 != null) {
                int t = l1.val + jinwei;
                l1.val = t % 10;
                jinwei = t / 10;
                pre = l1;
                l1 = l1.next;
            }
        }
        if(jinwei != 0) {
            pre.next = new ListNode(jinwei);
        }
        return head;
    }
}
