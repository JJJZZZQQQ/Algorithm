package codeTop;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的中序遍历 {
    //左中右
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            //当前节点入栈，并且往左子树继续入栈
            //当 当前节点的左节点为null之后，就可以输出 当前节点了，也就是栈顶元素
            //然后 把root的右节点设置为当前节点 准备开始下一次迭代
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;//为null的话会自动跳过第二个循环
        }
        return res;
    }
}
