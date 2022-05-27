package 力扣200题;

import utils.TreeNode;

public class 二叉树的直径 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        //从一个节点的左子树的最长的到右子树的最长的
        //返回的时候是左右子树最长的
        if (root == null) return 0;
        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);
        max = Math.max(max, leftLen + rightLen);
        return Math.max(leftLen, rightLen) + 1;
    }
}
