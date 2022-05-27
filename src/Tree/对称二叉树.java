package Tree;


import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 对称二叉树 {

    /**
     * 递归版
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root.right == null && root.left != null) return false;
        else if (root.right != null && root.left == null) return false;
        else if (root.right == null && root.left == null) return true;
        else return digui(root.left, root.right);
    }

    public boolean digui(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 != null && root2 == null) return false;
        else if (root1 == null && root2 != null) return false;
        else {
            if (root1.val != root2.val) return false;
            else return digui(root1.left, root2.right) && digui(root1.right, root2.left);
        }
    }

    /**
     * 迭代版:
     * 思路：一般树的递归转化为迭代就两种方法，利用栈或者利用队列
     * 这道题的遍历过程类似bfs，所以考虑用队列
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root.right == null && root.left != null) return false;
        else if (root.right != null && root.left == null) return false;
        else if (root.right == null && root.left == null) return true;
        else return bfs(root.left, root.right);
    }

    public boolean bfs(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root1);
        q.add(root2);
        while (!q.isEmpty()) {
            root1 = q.poll();
            root2 = q.poll();
            if (root1 == null & root2 == null) continue;
            else if (root1 == null || root2 == null || root1.val != root2.val) return false;

            q.add(root1.left);
            q.add(root2.right);

            q.add(root1.right);
            q.add(root2.left);
        }
        return true;
    }

}
