package leetcode每日一题;


/*本题的重要性质，二叉搜索树中序遍历的结果是一个递增有序的序列，故只需比较遍历出来的结果相邻的即可*/
public class 二叉搜索树节点最小距离 {
    static int ans = Integer.MAX_VALUE;
    static int pre = -1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        dfs(root);
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
