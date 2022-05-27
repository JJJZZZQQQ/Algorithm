package 剑指offer;

import utils.ListNode;

import java.util.HashSet;

public class 两个链表的第一个公共节点 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null && headB != null) {
            if (set.contains(headA)) {
                return headA;
            }
            set.add(headA);
            headA = headA.next;

            if (set.contains(headB)) {
                return headB;
            }
            set.add(headB);
            headB = headB.next;
        }
        while (headA != null) {
            if (set.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 思路：
     * 头节点 headA 到 node 前，共有 a - c个节点；
     * 头节点 headB 到 node 前，共有 b - c个节点；
     * 所以当a走了 a-c+b和b走了b-c+a时相遇
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }

    /**
     * 快慢指针差值法
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        int a = 0, b = 0;
        while (h1 != null && a++ >= 0) {
            h1 = h1.next;
        }
        while (h2 != null && b++ >= 0) {
            h2 = h2.next;
        }
        int cha = a - b;
        // b长，b先走差值
        if (cha < 0) {
            cha = -cha;
            for (int i = 0; i < cha; i++) {
                headB = headB.next;
            }
        } else if (cha > 0) {
            for (int i = 0; i < cha; i++) {
                headA = headA.next;
            }
        }
        while (headA != headB) {
            headB = headB.next;
            headA = headA.next;
        }
        return headA;
    }

}
