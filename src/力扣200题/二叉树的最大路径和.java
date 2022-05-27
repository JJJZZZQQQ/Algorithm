package 力扣200题;

import utils.TreeNode;

public class 二叉树的最大路径和 {
    int max = Integer.MIN_VALUE;

    //返回左右节点的最大路径和
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        //当 左子树最大值小于 0 的时候，就不要连接左子树了，用 0 代替
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        //节点的最大路径和应该是左右节点一起考虑
        max = Math.max(max, root.val + left + right);
        //如果是给父节点用，就只能左右子树选一个
        return root.val + Math.max(left, right);
    }

}
