package 树;

import utils.ListNode;
import utils.TreeNode;

import java.util.ArrayList;

public class 有序链表转平衡二叉树 {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList <Integer> list = new ArrayList<>();
        //先把链表转数组
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        return sortedArrayToBST(list.toArray(new Integer[0]),0, list.size()  - 1);
    }
    public TreeNode sortedArrayToBST(Integer[] nums , int left , int right) {
        if(left > right)return null;

        //找到当前序列的头节点，利用二叉搜索树的性质
        int rootIndex = (right + left) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = sortedArrayToBST(nums,left , rootIndex - 1);
        root.right = sortedArrayToBST(nums , rootIndex + 1 , right);
        return root;
    }
}
