package Tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class 二叉树的中序遍历 {
    @Test//迭代
    public void inorderTraversal() {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right =root2;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack <TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode nowNode = stack.peek();
            if(nowNode.left!=null){
                stack.push(nowNode.left);
                nowNode.left=null;
            }else {
                stack.pop();
                arrayList.add(nowNode.val);//遍历
                if(nowNode.right!=null) {
                    stack.push(nowNode.right);
                    nowNode.right=null;
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
        root.right =root2;
        TreeNode cur = root;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack <TreeNode> stack = new Stack<>();
        while (cur!=null||!stack.empty()){
            if(cur!=null){

            }
        }
        System.out.println(arrayList);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
