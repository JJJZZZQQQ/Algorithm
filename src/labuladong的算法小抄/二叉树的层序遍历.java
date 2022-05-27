package labuladong的算法小抄;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue <TreeNode>queue = new LinkedList();
        queue.add(root);
        List<List<Integer>> res = new LinkedList<>();
        if(root == null)return res;
        while(!queue.isEmpty()) {
            //代表当前这一步有多少种 可能 可以走
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0 ; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left != null) queue.add(poll.left);
                if(poll.right != null) queue.add(poll.right);
            }
            res.add(list);
        }
        return res;
    }
}
