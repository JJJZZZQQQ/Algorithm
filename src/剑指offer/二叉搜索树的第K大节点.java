package 剑指offer;

import utils.TreeNode;

import java.util.LinkedList;

public class 二叉搜索树的第K大节点 {

    LinkedList<Integer> list = new LinkedList<>();

    public int kthLargest(TreeNode root, int k) {
        dfs(root , k);
        return list.get(k  - 1);
    }
    //中序遍历，遍历到第k个就可以退出了
    public void dfs(TreeNode root , int k) {
        if(root == null || k == 0)return;
        dfs(root.right,k);
        list.add(root.val);
        k--;
        dfs(root.left,k);
    }
}
