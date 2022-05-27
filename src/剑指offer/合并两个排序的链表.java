package 剑指offer;

import utils.ListNode;

public class 合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null ){
            return null;
        }
        else if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }
        ListNode head = null;
        ListNode now = null;
        if(l1.val > l2.val){
            head = l2;
            l2 = l2.next;
        }
        else{
            head = l1;
            l1 = l1.next;
        }
        now = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                now.next = l2;
                l2 = l2.next;
            }
            else{
                now.next = l1;
                l1 = l1.next;
            }
            now = now.next;
        }
        if(l1 != null){
            now.next = l1;
        }
        else if(l2 != null){
            now.next = l2;
        }
        return head;
    }
}
