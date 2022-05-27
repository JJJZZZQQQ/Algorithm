package 剑指offer;

import utils.ListNode;

public class 链表中倒数第k个节点 {

    /** 初始化： 前指针 former 、后指针 latter ，双指针都指向头节点 head 。
        构建双指针距离： 前指针 former 先向前走 k 步（结束后，双指针 former 和 latter 间相距 k 步）。
        双指针共同移动： 循环中，双指针 former 和 latter 每轮都向前走一步，直至 former 走过链表 尾节点 时跳出（跳出后， latter 与尾节点距离为 k-1k−1，即 latter 指向倒数第 kk 个节点）。
        返回值： 返回 latter 即可。
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null)
            return null;
        ListNode fast = head;
        ListNode low = head;
        while(k-- > 0 ){
            fast = fast.next;
        }
        while(fast != null){
            low = low.next;
            fast = fast.next;
        }
        return low;
    }
}
