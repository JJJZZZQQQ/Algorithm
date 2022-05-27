package 力扣200题;

import utils.TreeNode;

public class 二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))return;
        //左子树插到根节点和右子树中间，把右子树移到左子树的最右端
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left = null;
        TreeNode t = left;
        if(left != null) {
            while (t.right != null) {
                t = t.right;
            }
            t.right = right;
            root.right = left;
        }
        flatten(root.right);
    }
}
