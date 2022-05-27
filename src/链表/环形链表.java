package 链表;

import org.junit.Test;
import utils.ListNode;

public class 环形链表 {
    @Test
    public void main() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = a;
        System.out.println(detectCycle(a).val);
    }

    public Boolean hasCycle(ListNode head) {
        ListNode low = head;
        ListNode high = head;
        while(high != null && high.next != null ){
            low = low.next;
            high = high.next.next;
            if(low == high)return true;
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)return null;
        ListNode low = head;
        ListNode high = head;
        while(high != null && high.next != null ){
            low = low.next;
            high = high.next.next;
            if(low == high)break;
        }
        if(low != high)return null;
        ListNode t = head;
        while(t != low){
            t = t.next;
            low = low.next;
        }
        return t;
    }
}
