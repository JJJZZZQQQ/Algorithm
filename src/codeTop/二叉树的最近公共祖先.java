package codeTop;

import utils.TreeNode;

public class 二叉树的最近公共祖先 {
    /**
     * 思路：肯定是递归，递归体返回的是当前子树是否存在 p 或者 q
     * 如果都没找到，就返回null，说明这个节点没用
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return root;
        TreeNode leftRes = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRes = lowestCommonAncestor(root.right, p, q);
        if (leftRes == null && rightRes == null) return null;
        if(leftRes == null)return rightRes;
        if(rightRes == null)return leftRes;
        //如果左右两个节点都找到了，那么就把当前的节点返回
        return root;
    }
}
