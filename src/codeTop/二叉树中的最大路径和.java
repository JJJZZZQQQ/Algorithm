package codeTop;

import utils.TreeNode;

public class 二叉树中的最大路径和 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //递归，每次递归判断一下 左子树 + 右子树 + root.val是否超过最大值，超过就替换
        //递归返回的结果只能是选左子树或者是选右子树或者0或者root.var
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root) {
        if(root == null)return 0;
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        int cur = root.val;
        if(leftMax > 0)cur += leftMax;
        if(rightMax > 0)cur += rightMax;
        if(cur > max)max = cur;
        return root.val + Math.max(0,Math.max(leftMax,rightMax));
    }
}
