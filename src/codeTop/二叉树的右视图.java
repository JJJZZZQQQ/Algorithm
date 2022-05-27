package codeTop;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return new LinkedList<>();
        Deque <TreeNode> deque = new LinkedList<>();
        deque.push(root);
        List<Integer> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                if(pop.left != null)deque.add(pop.left);
                if(pop.right != null)deque.add(pop.right);
                if(i == size - 1)res.add(pop.val);
            }
        }
        return res;
    }
}
