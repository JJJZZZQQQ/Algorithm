package 剑指offer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的前序遍历 {
    List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        fun(root);
        return res;
    }
    public void fun(TreeNode root) {
        if(root == null)return;
        res.add(root.val);
        fun(root.left);
        fun(root.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List <Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)return res;
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            res.add(pop.val);
            if(pop.right != null)stack.add(pop.right);
            if(pop.left != null)stack.add(pop.left);
        }
        return res;
    }
}
