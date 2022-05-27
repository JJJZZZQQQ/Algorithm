package codeTop;

import utils.ListNode;

public class 环形链表Ⅱ {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)return null;
        //先判断是否有环
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow)break;
        }
        if(fast != slow) {
            return null;
        }
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
