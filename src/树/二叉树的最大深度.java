package 树;

import utils.TreeNode;

public class 二叉树的最大深度 {
    int max = Integer.MIN_VALUE;
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        dfs(root , 1);
        return max;
    }
    public void dfs(TreeNode root , int depth) {
        if(root == null)return;
        dfs(root.left , depth + 1);
        //判断是不是叶子节点
        if(root.left == null && root.right == null) {
            if(depth > max)max = depth;
        }
        dfs(root.right,depth + 1);
    }
}
