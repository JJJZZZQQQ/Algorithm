package codeTop;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cen = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                cen.add(poll.val);
                if(poll.left != null)queue.add(poll.left);
                if(poll.right != null)queue.add(poll.right);
            }
            res.add(cen);
        }
        return res;
    }
}
