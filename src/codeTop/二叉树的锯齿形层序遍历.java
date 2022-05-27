package codeTop;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> cen = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(flag) cen.add(poll.val);
                else cen.addFirst(poll.val);
                if(poll.left != null)queue.add(poll.left);
                if(poll.right != null)queue.add(poll.right);
            }
            res.add(cen);
            flag = !flag;
        }
        return res;
    }
}
