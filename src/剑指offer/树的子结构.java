package 剑指offer;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 树的子结构 {

    /** dfs + 回溯  ？ 好像不可行
     *  考虑 暴力搜索，
     *  先维护一个队列，把所有和B树根节点相等的节点放入队列中，然后把队列中的每个节点再取出来比较是否是两个相等的树*/
    static Queue < TreeNode > queue = new LinkedList<>();

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //先递归一次,把相等的节点加入队列
        if(B == null )return false;
        recur(A,B.val);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(equals(node,B))
                return true;
        }
        return false;
    }

    public boolean equals(TreeNode A , TreeNode B){
        if(B == null )return true;
        else if(A == null )
            return false;
        if(A.val != B.val)
            return false;
        else
            return equals(A.left,B.left) && equals(A.right,B.right);
    }


    public void recur (TreeNode A ,int routValue){
        if(A == null)return;
        if(A.val == routValue)queue.add(A);
        recur(A.left,routValue);
        recur(A.right,routValue);
    }
}
