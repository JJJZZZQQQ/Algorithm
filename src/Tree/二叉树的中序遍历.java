package Tree;

import org.junit.Test;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历 {
    @Test//迭代
    public void inorderTraversal() {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right = root2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode nowNode = stack.peek();
            if (nowNode.left != null) {
                stack.push(nowNode.left);
                nowNode.left = null;
            } else {
                stack.pop();
                arrayList.add(nowNode.val);//遍历
                if (nowNode.right != null) {
                    stack.push(nowNode.right);
                    nowNode.right = null;
                }
            }
        }
        System.out.println(arrayList);
        //return arrayList;
    }

    @Test//题解版迭代
    public void inorderTraversal2() {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right = root2;
        TreeNode cur = root;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.empty()) {
            if (cur != null) {

            }
        }
        System.out.println(arrayList);
    }


    @Test
    public void testTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        inorderTraversal(root);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null)return res;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {
                //当前节点不为null,就一直往左边遍历
                stack.push(cur);
                cur = cur.left;
            } else {
                //当前节点为null时,说明左边的节点已经访问完了,可以开始进行处理了
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }

        }
        return res;
    }

}
