package 动态规划;

import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

public class 打家劫舍Ⅲ {
    @Test
    public void tset1() {
        int[] dp = new int[100];
        TreeNode root = new TreeNode(1);


    }

    /**
     * 递归实现，时间超限，因为中间多了很多重复的步骤
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null) sum += rob(root.left.left) + rob(root.left.right);
        if (root.right != null) sum += rob(root.right.right) + rob(root.right.left);
        //比较选这个和子子结点或者选子结点哪种大
        return Math.max(sum + root.val, rob(root.left) + rob(root.right));
    }

    /**
     * 递归优化，通过记忆化减少重复的计算步骤，如果已经计算过了，就直接从缓存中取
     * 缓存数据结构的选择：由于是二叉树，每个结点对应的值不好用数组来表示，所以用
     * 哈希表来缓存
     * 执行用时：
     * 3 ms在所有 Java 提交中击败了53.03%的用户
     * 内存消耗：
     * 38.2 MB在所有 Java 提交中击败了39.07%的用户
     */
    public int robyouhua(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return robdfs(root, map);
    }

    public int robdfs(TreeNode res, HashMap<TreeNode, Integer> map) {
        if (res == null) return 0;
        //如果已经计算过了，就直接取里面的值就可以了
        if (map.containsKey(res)) return map.get(res);
        int sum = 0;
        if (res.left != null) sum += robdfs(res.left.left, map) + robdfs(res.left.right, map);
        if (res.right != null) sum += robdfs(res.right.right, map) + robdfs(res.right.left, map);
        int result = Math.max(sum + res.val, robdfs(res.left, map) + robdfs(res.right, map));
        map.put(res, result);
        return result;
    }

    /**
     * 动态规划：
     */
    public int robdp(TreeNode root) {
        return 0;
    }

    public class TreeNode {
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
}
