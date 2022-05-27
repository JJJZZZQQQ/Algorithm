package 剑指offer;

import utils.ListNode;

public class 反转链表 {
    /** 递归实现
     * 1.递归的参数：一个链表节点，表示当前要反转的链表节点
     * 2.递归的过程：
     *          先递归调用链表的next节点
     *          再将一个链表的下一个节点指向当前节点
     *          这样递归函数做的事会从链表尾部开始一直执行到链表头部
     * 3.递归最后返回新的头节点
     * */
    public ListNode reverseList(ListNode head) {
        //空链表和最后一个节点的情况
        if(head == null || head.next == null)return head;
        //一定要先递归，不然如果先反转指针的话，下一次递归的时候next指针的值就不对了
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        //这一步对于除了头节点之外的节点没有任何影响，会在下一次递归时又指向正确的节点
        head.next = null;
        return newHead;
    }
}
