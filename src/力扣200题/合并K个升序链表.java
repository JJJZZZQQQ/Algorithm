package 力扣200题;

import utils.ListNode;

public class 合并K个升序链表 {
    //最蠢的办法，两个两个归并
    //时间复杂度 mn
    //可不可以类似于归并排序
    //单个链表都是有序的
    //递归终止的条件：数组里只有一个元素
    //递归的过程，左子数组返回的链表和右子树返回链表递归，保证这次返回的链表有序
    //递归返回的结果：返回一个有序链表
    //时间复杂度  logN * M
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0)return null;
        return mergeSorts(0, n - 1, lists);
    }

    public ListNode mergeSorts(int left, int right, ListNode[] lists) {
        if (left >= right) return lists[left];
        int mid = (left + right) / 2;
        ListNode leftList = mergeSorts(left, mid , lists);
        ListNode rightList = mergeSorts(mid + 1 , right ,lists);
        return merge(leftList,rightList);
    }

    //归并两个链表
    //可以改变一下思路，不需要把l2归并到l1里，只需要两个一起归并就行了
    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)return null ;
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        ListNode head;
        if(l1.val > l2.val) {
            head = l2;
            l2 = l1;
            l1 = head;
        } else {
            head = l1;
        }
        //把l2 合并到 l1上 ,保证l1的头节点的值小
        while (l1.next != null && l2 != null) {
            if(l1.next.val < l2.val) {
                l1 = l1.next;
            } else {
                ListNode newL2 = l2.next;
                l2.next = l1.next;
                l1.next = l2;
                l1 = l2;
                l2 = newL2;
            }
        }
        //出来的时候如果 l1.next == null ， 那么l1就走完了
        if(l2 != null) {
            l1.next = l2;
        }
        //如果是l2 == null 出来的，直接返回l1就行了
        return head;
    }
    public ListNode merge2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            //合并l1的当前节点
            if(l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        //肯定有一个还没有合并
        if(l1 == null) {
            pre.next = l2;
        } else {
            pre.next = l1;
        }
        return dummy.next;
    }
}
