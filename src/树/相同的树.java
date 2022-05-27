package 树;

import utils.TreeNode;

public class 相同的树 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)return true;
        if(p == null)return false;
        if(q == null)return false;
        if(p.val != q.val)return false;
        return isSameTree(p.right , q.right) && isSameTree(p.left , q.left);
    }
}
