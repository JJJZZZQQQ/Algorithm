package codeTop;

import utils.TreeNode;

public class 求根节点到叶节点数字之和 {
    private int res;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    //val 代表当前值
    public void dfs(TreeNode root, int val) {
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += val;
        }

        if (root.left != null) dfs(root.left, val);
        if (root.right != null) dfs(root.right, val);
    }
    //返回子树的结果和
    public int sumNumbers(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 10 + root.val;
        if (root.left == null && root.right == null) {
            return val;
        }
        return sumNumbers(root.left, val) + sumNumbers(root.right, val);
    }
}
