package 剑指offer;

import utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class 从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if(root == null)return new int[0];
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                res.add(poll.val);
                if(poll.left != null)queue.add(poll.left);
                if(poll.right != null)queue.add(poll.right);
            }
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cengList = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                cengList.add(poll.val);
                if(poll.left != null)queue.add(poll.left);
                if(poll.right != null)queue.add(poll.right);
            }
            res.add(cengList);
        }
        return res;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        if(root == null)return new ArrayList<>();
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cengList = new LinkedList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                cengList.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);

            }
            if(flag) {
                //翻转一下集合
                Collections.reverse(cengList);
            }
            res.add(cengList);
            flag = !flag;
        }
        return res;
    }
}
