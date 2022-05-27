package 链表;

import org.junit.Test;
import utils.ListNode;

public class 两数相加 {
    @Test
    public void test() {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode res = new ListNode();
        ListNode now = res;
        while (t1 != null && t2 != null) {
            int t = t1.val + t2.val;
            now.val = t;
            t1 = t1.next;
            t2 = t2.next;
            now.next = new ListNode();
            now = now.next;
        }
        if (t1 != null) {
            while (t1 != null) {
                now.val = t1.val;
                t1 = t1.next;
                now.next = new ListNode();
                now = now.next;
            }
        }
        if (t2 != null) {
            while (t2 != null) {
                now.val = t2.val;
                t2 = t2.next;
                now.next = new ListNode();
                now = now.next;
            }
        }
        now = res;
        while (now != null) {
            if (now.val >= 10) {
                now.val %= 10;
                now.next.val += 1;
            }
            if (now.next != null && now.next.val == 0 && now.next.next == null) {
                now.next = null;
            }
            now = now.next;
        }
        return res;
    }
}
