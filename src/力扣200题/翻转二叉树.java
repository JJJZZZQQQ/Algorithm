package 力扣200题;

import utils.TreeNode;

public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)return null;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = invertTree(rightNode);
        root.right = invertTree(leftNode);
        return root;
    }
}
