package 力扣200题;

import org.junit.Test;
import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 回文链表 {

    @Test
    public void main() {
        ListNode head = new ListNode(1);
        ListNode tail = new ListNode(2);
        head.next = tail;
        tail.next = null;
        isPalindrome(head);
    }
    public boolean isPalindrome(ListNode head) {
        List <Integer> list = new ArrayList<>();
        ListNode t = head;
        while(t!=null){
            list.add(t.val);
            t = t.next;
        }
        for(int i = 0 ; i < list.size()/2 ; i++){
            if(list.get(i) != list.get(list.size()-1-i))return false;
        }
        return true;
    }
    /** 进阶，快慢指针*/
    public boolean isPalindrome2(ListNode head) {
        return false;
    }

}
