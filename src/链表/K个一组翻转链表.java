package 链表;

import utils.ListNode;

public class K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //假头节点，为了编程的方便设置
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //pre为要反转的区间的前一个节点
        ListNode pre = dummy;
        //end为要反转区间的最后一个节点
        ListNode end = dummy;

        while (end != null) {
            //循环k次
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if(end == null)break;
            //开始准备反转
            //为什么需要start节点，为了翻转后能找到下一次要翻转的节点的前一个几点
            ListNode start = pre.next;
            //为什么需要next，为了找到下一次翻转的节点，然后把他们连上
            ListNode next = end.next;
            //为什么需要这一步，为了使这次翻转链表只翻转到end
            end.next = null;
            //翻转 start到end
            pre.next = reverseList(start);
            start.next = next;
            //准备开始下一次循环
            pre = start;
            end = start;
        }
        return dummy.next;
    }
    //dummy - 1 - 2 - 3 - 4
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        //把head连上dummy
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end != null) {
            //end要防止出链表
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if(end == null)break;
            ListNode next = end.next;
            ListNode start = pre.next;

            end.next = null;
            pre.next = reverseList(start);
            start.next = next;
            //重置条件
            pre = start;
            end = start;
        }
        return dummy.next;
    }
    public ListNode reverseList(ListNode head) {
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
