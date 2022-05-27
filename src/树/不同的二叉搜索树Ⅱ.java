package 树;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class 不同的二叉搜索树Ⅱ {

    List<TreeNode> res = new LinkedList<>();

    /**
     * List< TreeNode > 考虑能不能把上一道题的那个规律结合一下
     * 就是一个节点为根节点的所有树的数量等于左子树数量 和 右子树数量 的乘积
     * 也就是左子树和右子树排列
     * <p>
     * 这里的返回的结果是一个头节点的集合，我们要把所有的节点插到节点上然后把头节点加到集合里面
     * 递归终止的条件 ：
     * <p>
     * 递归中间：
     * 递归求出左子树的节点数组
     * 递归求出右子树的节点数组
     * 两个数组相排列
     * 得到的数组就是当前节点为根节点时 的 数组
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<TreeNode>();
        return dfs(1, n);
    }

    //该函数返回的结果是值从start到end的树一共有多少中可能性，并且TreeNode指的是头节点
    public List<TreeNode> dfs(int start, int end) {
        //最后返回的结果集
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        //枚举所有可能的根节点，当前子树的值为 start 到end ，那么可能的根节点就是其中一个
        for (int i = start; i <= end; i++) {
            //获得所有的左子树集合
            List<TreeNode> left = dfs(start, i - 1);
            //获得所有的右子树集合
            List<TreeNode> right = dfs(i + 1, end);
            //排列，并且把结果加入allTrees
            for (TreeNode leftTreeNode : left) {
                for (TreeNode rightTreeNode : right) {
                    //用当前i当做根节点，每一次排列都相当于一颗新的树
                    //所以根节点是在这里 new 一个新的根节点，而不是在外层循环
                    //并且我们也只需要把跟节点的左右节点设置了值即可，左右子树的交给递归下一次来考虑
                    TreeNode curTree = new TreeNode(i);
                    curTree.left = leftTreeNode;
                    curTree.right = rightTreeNode;
                    allTrees.add(curTree);
                }
            }
        }
        return allTrees;
    }
}
