package 剑指offer;

import utils.ListNode;

public class 回文链表第二次 {
    public boolean isPalindrome(ListNode head) {
        //快慢指针找到中点
        int size = 0;
        ListNode fast = head,slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //由于节点个数为奇数还是为偶数
        //偶数时，直接从中点开始反转
        ListNode mid;
        if(fast == null){
            mid = reverseList(slow);
        }
        //奇数时，中点的下一个开始反转
        else {
            mid = reverseList(slow.next);
        }
        while (mid != null) {
            if(head.val != mid.val)return false;
            mid = mid.next;
            head = head.next;
        }
        return true;
    }
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
