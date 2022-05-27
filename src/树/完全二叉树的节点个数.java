package 树;

import utils.TreeNode;

public class 完全二叉树的节点个数 {


    public int countNodes(TreeNode root) {
        TreeNode left = root ;
        TreeNode right = root;
        //分别计算左右子树的高度
        //如果相同，说明是满二叉树
        //不相同，就递归
        int l = 0 , r = 0;
        while( left != null) {
            l++;
            left = left.left;
        }
        while (right != null) {
            r++;
            right = right.right;
        }
        if(l == r){
            return (int)Math.pow(2,l) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
