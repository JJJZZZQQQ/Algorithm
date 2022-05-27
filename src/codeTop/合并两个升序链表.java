package codeTop;

import utils.ListNode;

public class 合并两个升序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode now = dummy;
        while (list1 != null && list2 != null) {
            //合并list1
            if(list1.val < list2.val) {
                now.next = list1;
                now = list1;
                list1 = list1.next;
            } else {
                now.next = list2;
                now = list2;
                list2 = list2.next;
            }
        }
        now.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
