package 树;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class 恢复二叉搜索树 {
    //不改变其结构，代表可以改变值
    //如果使用额外空间，可以考虑利用中序遍历有序的特点
    //正常   1 2 3
    //不正常 3  2 1
    //正常   1 2 3 4
    //不正常  1 3 2 4
    //交换这两个排序不正确的节点值即可
    TreeNode a ;
    TreeNode b ;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        fun(root);
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }
    public void fun (TreeNode root) {
        if(root == null)return;
        fun(root.left);
        if(pre != null && pre.val > root.val ) {
            //注意，这里很重要，因为肯定第一个不按序的值才是第一个要交换的 a
            if(a == null) a = pre;
            //最后一个不按序的才是第二个要交换的 b
            b = root;
        }
        pre = root;
        fun(root.right);
    }
}
