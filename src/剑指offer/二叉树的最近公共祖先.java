package 剑指offer;

import utils.TreeNode;

public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null)return null;
        if(left != null && right != null)return root;
        if(left == null) {
            return right;
        }
        return left;

    }
}
