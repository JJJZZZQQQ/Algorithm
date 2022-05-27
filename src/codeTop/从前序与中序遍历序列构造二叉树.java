package codeTop;

import utils.TreeNode;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class 从前序与中序遍历序列构造二叉树 {

    /**
     * 思路
     * 从前序遍历中拿到当前子树的头节点
     * 在中序遍历中找到头节点的位置(用一个HashMap保存)，找到左子树的区间和右子树的区间
     * 递归 使当前头节点 的左指针 指向 递归左子树区间的结果，右指针指向 递归右子树区间的结果
     * 递归返回的条件如果左右子树区间 的left > right 的话，直接返回null
     */
    private Map<Integer, Integer> index = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }
        return recur(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode recur(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inIndex = index.get(root.val);
        //左子树的大小
        int leftSize = inIndex - inLeft;
        root.left = recur(preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, inIndex - 1);
        root.right = recur(preorder, inorder, preLeft + leftSize + 1, preRight, inIndex + 1, inRight);
        return root;
    }
}
