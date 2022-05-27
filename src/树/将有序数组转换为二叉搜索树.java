package 树;

import utils.TreeNode;

public class 将有序数组转换为二叉搜索树 {
    /** [-10,-3,0,5,9]
     * 考虑应该是递归，递归返回的是孩子节点 ， 然后把该树的左右节点接上*/
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums , 0 , nums.length - 1);
    }
    public TreeNode sortedArrayToBST(int[] nums , int left , int right) {
        if(left > right)return null;

        //找到当前序列的头节点，利用二叉搜索树的性质
        int rootIndex = (right + left) / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = sortedArrayToBST(nums,left , rootIndex - 1);
        root.right = sortedArrayToBST(nums , rootIndex + 1 , right);
        return root;
    }
}
