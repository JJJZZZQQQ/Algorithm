package codeTop;

import utils.TreeNode;

public class 二叉树的最大深度 {
    /** DFS版：递归就行了，每次递归返回的时候就+1，如果为null返回0，然后每一层的深度等于左右子树的最大值*/
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
