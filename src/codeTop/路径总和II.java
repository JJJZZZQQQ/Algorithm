package codeTop;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 路径总和II {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        back(root, targetSum, new LinkedList<>());
        return res;
    }

    public void back(TreeNode root, int targetSum, LinkedList<Integer> list) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList<>(list));
        }
        back(root.left,targetSum,list);
        back(root.right,targetSum,list);
        list.removeLast();
    }
}
