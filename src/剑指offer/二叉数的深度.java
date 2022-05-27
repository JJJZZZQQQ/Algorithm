package 剑指offer;

import utils.TreeNode;

public class 二叉数的深度 {
    int max = 0;
    int now = 0;
    public int maxDepth(TreeNode root) {
        dfs(root);
        return max;
    }
    public void dfs(TreeNode root) {
        if(root == null) {
            if(now > max)max = now;
            return;
        }
        now++;
        dfs(root.left);
        dfs(root.right);
        now--;
    }
}
