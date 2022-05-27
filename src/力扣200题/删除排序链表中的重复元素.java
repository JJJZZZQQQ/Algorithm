package 力扣200题;

import utils.ListNode;

public class 删除排序链表中的重复元素 {
    /**
     * */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode dummy = new ListNode(-1000);
        dummy.next = head;
        ListNode now = head;
        ListNode pre = dummy;
        while ( now != null && now.next != null) {
            while (now != null && now.next != null && now.next.val == now.val) {
                now = now.next;
            }
            pre.next = now;
            pre = pre.next;
            now = now.next;

        }
        return dummy.next;
    }
}
