package 树;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        int min = 1;
        Queue <TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                //判断这个节点是不是叶子节点
                if(poll.left == null && poll.right == null) {
                    return min;
                }
                if(poll.left != null)queue.add(poll.left);
                if(poll.right != null)queue.add(poll.right);
            }
            min++;
        }
        return min;
    }
}
