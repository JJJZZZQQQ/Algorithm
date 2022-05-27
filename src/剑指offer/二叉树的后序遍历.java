package 剑指offer;

import utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class 二叉树的后序遍历 {
    List<Integer> res = new LinkedList<>();

    /** 迭代的思路
     * 前序遍历很方便   中  左  右
     * 后续遍历只是中间add进结果的位置不一样。可以考虑在结果集的头部
     * 我们可以修改 val进入结果集的位置就行了，很巧妙  */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)return res;
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode  head= stack.pop();
            res.addFirst(head.val);
            if(head.left != null)stack.add(head.left);
            if(head.right != null)stack.add(head.right);

        }
        return res;
    }
    public void fun(TreeNode root) {
        if(root == null)return;

        fun(root.left);
        fun(root.right);
        res.add(root.val);
    }

}
