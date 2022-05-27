package 树;

import utils.TreeNode;

public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE );
    }

    public boolean isValidBST(TreeNode root, Long min, Long max) {
        if (root == null) return true;
        //左子树不能比之前的最小值大
        if(root.val >= min)return false;

        //右子树不能比之前的最大值小
        if(root.val <= max)return false;

        //注意，这里的最大最小值要根据左右子树来确定具体的值
        //左子树要用当前值取代最小值，最大值不变
        //右子树要用当前值取代最大值，最小值不变
        return isValidBST(root.left, (long) root.val , max) && isValidBST(root.right , min ,(long) root.val);
    }
}
