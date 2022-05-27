package labuladong的算法小抄;

import utils.ListNode;

public class 链表中环的入口节点 {


    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(fast == null || fast.next == null)return null;
        //一开始都等于head，不要直接在while里面判断
        while(fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)break;
        }
        if(slow != fast)return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
