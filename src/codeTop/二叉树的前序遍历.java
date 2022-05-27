package codeTop;

import utils.ListNode;
import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的前序遍历 {
    public List<Integer> preorderTraversal(TreeNode root) {
        //中左右
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        List<Integer> res = new LinkedList<>();
        while (root != null && !stack.isEmpty()) {
            TreeNode pop = stack.removeFirst();
            res.add(pop.val);
            if(pop.right != null)stack.addFirst(pop.right);
            if(pop.left != null)stack.addFirst(pop.left);
        }
        return res;
    }
}
