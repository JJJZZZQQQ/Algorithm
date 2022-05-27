package codeTop;

import utils.ListNode;

public class 反转链表 {
    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        ListNode now = head;
        while (now != null) {
            next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }
    //递归
    //递归体
    public ListNode reverseList2(ListNode head) {
        //最后一个结点
        if(head == null || head.next == null)return head;
        ListNode newHead = reverseList2(head.next);
        //会是倒数第二个结点先执行，有点像反过来的dfs
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
