package 剑指offer;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉数的中序遍历 {
    /**  左 中 右
     * 迭代的思路：把左子树处理完之后，然后把中间节点加入res，然后再递归处理右节点*/
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.add(root);
                root = root.left;
            }
            //说明此时左边已经没有节点了，可以开始遍历了 ， 所以拿一个节点出来
            root = stack.pop();
            res.add(root.val);
            //把当前节点的右子树设为当前根节点，继续下一次迭代，因为当前节点可以看作是中
            root = root.right;
            //stack.add(root.right);
        }
        return res;
    }
}
