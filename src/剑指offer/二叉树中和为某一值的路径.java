package 剑指offer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树中和为某一值的路径 {

    List<List<Integer>> res = new LinkedList<>();

    /**
     * DFS
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        dfs(new LinkedList<Integer>(), root, target);
        return res;
    }

    public void dfs(LinkedList<Integer> list, TreeNode root, int target) {
        if(root == null)return;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            res.add(new LinkedList<>(list));
        dfs(list,root.left,target);
        dfs(list,root.right,target);

        //list.remove(root.val);这个里面是下标，当然会越界
        list.removeLast();
    }


    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}
