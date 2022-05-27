package 链表;

import utils.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class 反转链表 {

    /**
     * 迭代
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode prev = null;
        ListNode now = head;
        ListNode next = head.next;
        while (now != null) {
            now.next = prev;
            prev = now;
            now = next;
            if (now != null) next = now.next;
        }
        return prev;
    }

    /**
     * 递归
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //一直递归会把尾结点返回
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        //防止1指向2，2指向1，把1指向null，防止出现环链表
        head.next = null;
        //尾结点就是新的头结点，返回新的头结点
        return newHead;
    }
}
