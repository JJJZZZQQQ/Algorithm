package 力扣200题;

import utils.TreeNode;

public class 把二叉搜索树转换为累加树 {
    //遍历顺序
    //右中左
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null)return null;
        root.right = convertBST(root.right);
        sum += root.val;
        root.val = sum;
        root.left = convertBST(root.left);
        return root;
    }
}
