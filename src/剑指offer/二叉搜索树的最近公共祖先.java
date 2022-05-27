package 剑指offer;

import utils.TreeNode;

public class 二叉搜索树的最近公共祖先 {

    /** 利用搜索树的性质，比较值就能知道是在左子树还是右子树
     * 树的题优先考虑能不能递归求解
     * 递归退出的条件：
     * pq在root的异侧 (p < root && q > root)  ||  (p > root && q < root )</>
     * p == root ，且q在root的左右子树
     * q == root ，且p在root的左右子树
     * 这三种情况都说明root是最近祖先
     *
     * 否则，如果 p < root && q < root 说明都在左子树，当前root不可能是最近祖先，至少也是root的左孩子是最近祖先
     * 同理....
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }else if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}
