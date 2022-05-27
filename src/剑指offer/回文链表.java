package 剑指offer;

import utils.ListNode;

public class 回文链表 {
    public ListNode reserve(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode t = head.next;
            head.next = pre;
            pre = head;
            head = t;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        //处理空链表
        if(head == null || head.next == null){
            return true;
        }
        boolean res = true;
        //先找到中间节点,两种情况都要考虑，奇数节点的情况和偶数的情况  1 2 3 4     1 2 3 4 5
        //快慢指针找中间节点
        ListNode low = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }
        //分情况
        //偶数的情况，此时low就是开始反转的中间节点
        ListNode left = head;
        ListNode right;
        if(fast == null){
            right = reserve(low);
        }
        //奇数的情况
        else {
            right = reserve(low.next);
        }
        //开始遍历比较
        while(right != null){
            if(left.val != right.val){
                res = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        return res;
    }
}
