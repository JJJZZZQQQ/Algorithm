package 剑指offer;

import utils.TreeNode;

public class 平衡二叉树 {

    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        fun(root , 0);
        return res;
    }

    /** 递归返回左右子树的最大高度*/
    public int fun(TreeNode root , int high) {
        if(root == null) {
            return high;
        }
        int left = fun(root.left , high + 1) ;
        int right = fun(root.right , high + 1);
        if(Math.abs(left - right) > 1)res = false;
        return Math.max(left , right);
    }

}
