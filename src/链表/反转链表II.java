package 链表;

import utils.ListNode;

public class 反转链表II {

    ListNode next ;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //注意处理left = 1 的情况
        if(left == 1) {
            return reverseBetween(head,right - left);
        }
        //head指向要反转节点的上一个节点
        ListNode res = head;
        for (int i = 2; i < left && head != null; i++) {
            head = head.next;
        }
        head.next = reverseBetween(head.next, right - left);
        return res;
    }

    public ListNode reverseBetween(ListNode head , int n) {
        if(n == 0){
            next = head.next;
            return head;
        }
        ListNode newHead = reverseBetween(head.next , n -1);
        head.next.next = head;
        head.next = next;
        return newHead;
    }

}
