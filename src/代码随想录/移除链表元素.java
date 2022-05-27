package 代码随想录;

import utils.ListNode;

public class 移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(100);
        dummy.next = head;
        ListNode now = head;
        ListNode pre = dummy;
        while (now != null) {
            while (now != null && now.val != val) {
                pre = now;
                now = now.next;
            }
            if(now == null)break;
            //此时找到了 一个和目标元素相同的元素
            pre.next = now.next;
            now = now.next;
        }
        return  dummy.next;
    }
}
