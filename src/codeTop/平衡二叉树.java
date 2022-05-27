package codeTop;

import utils.TreeNode;

public class 平衡二叉树 {

    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return res;
    }
    //如果为null，返回0值
    //返回该子树的高度值
    //判断差值
    public int depth(TreeNode root) {
        if(root == null)return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if(Math.abs(right - left) > 1)res = false;
        return Math.max(left,right) + 1;
    }
}
