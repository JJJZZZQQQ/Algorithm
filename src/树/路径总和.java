package 树;

import sun.reflect.generics.tree.Tree;
import utils.TreeNode;

public class 路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        targetSum -= root.val;
        if(root.left == null && root.right == null ){
            if(targetSum == 0)
                return true;
            else return false;
        }
        boolean res = false;
        if(root.left != null){
            res = res || hasPathSum(root.left , targetSum );
        }
        if(root.right != null) {
            res = res || hasPathSum(root.right , targetSum);
        }
        return res ;

    }
}
