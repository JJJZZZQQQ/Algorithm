package 剑指offer;

import org.junit.Test;
import utils.TreeNode;

public class 先序中序重建二叉树 {

    @Test
    public void buildTree() {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        int n = preorder.length;
        if(n == 0 );

         recur(preorder,inorder,0,n - 1,0,n-1);
    }

    /** Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] */
    public TreeNode recur(int[] preorder, int[] inorder,int preLeft , int preRight, int inLeft , int inRight){
        //递归函数终止条件
        if(preLeft > preRight){
            return null;
        }
        //首先根据先序找头结点
        int rootValue = preorder[preLeft];
        //然后再在中序遍历中通过头节点的位置判断左子树和右子树的长度
        int leftLen = 0;
        int rightLen = 0;
        boolean flag = true;
        int rootIn = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if(inorder[i] == rootValue){
                rootIn = i;
                flag = false;
            }
            else if(flag){
                leftLen++;
            }
            else {
                rightLen++;
            }
        }
        //回到先序遍历中通过子树长度确定左子树头结点和右子树头结点
        //通过递归构建左右子树
        TreeNode root = new TreeNode(rootValue);
        root.left = recur(preorder,inorder,preLeft+1,preLeft + leftLen, inLeft ,rootIn - 1);
        root.right = recur(preorder,inorder,preLeft + leftLen + 1,preLeft + leftLen + rightLen,rootIn + 1,inRight);
        //返回当前节点
        return root;
    }
}
