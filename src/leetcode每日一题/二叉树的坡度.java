package leetcode每日一题;

public class 二叉树的坡度 {
    /**
     * 递归返回的结果为子树的节点之和
     * 分解坡度问题，因为如果想求坡度之和 ， 最优子结构是 不可能 求出 每个节点的坡度的。
     */
    int res = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return res;
    }
    public int sum(TreeNode root) {
        if (root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }

}
