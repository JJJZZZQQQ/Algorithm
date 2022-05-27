package 力扣200题;

import utils.ListNode;

public class 删除排序链表中的重复元素II {
    /**
     * 双指针遍历，不相同就直接往下
     * 相同的话 右指针一直遍历 ，直到下一个不等于的节点，然后把中间全部删除
     * -100     1     2     3    3     4  4   5
     *   pre  now    next
     * 操作  1 2 4
     * pre.next = next;
     * now = next;
     * next = now.next;
     **/
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode dummy = new ListNode(-1000);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode now = head;
        ListNode next = head.next;
        boolean flag = true;
        while (next != null) {
            while( next != null && now.val == next.val) {
                next = next.next;
                flag = false;
            }
            //此时不相等或者 next 为null
            //说明有重复的
            if(!flag) {
                pre.next = next;
                now = next;
            } else {
                pre = pre.next;
                now = now.next;
            }
            if(now != null)next = next.next;
            flag = true;
        }

        return dummy.next;
    }
}
