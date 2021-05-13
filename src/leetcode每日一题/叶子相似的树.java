package leetcode每日一题;

import sun.swing.plaf.synth.DefaultSynthStyle;

import java.util.ArrayList;

public class 叶子相似的树 {
    public static void main(String[] args) {

    }
    /**分别遍历两棵树的叶子节点，将其分别放入List里面，
     * 然后比较两个Set是否一样*/
    public  boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = leafList(root1);
        ArrayList<Integer> list2 = leafList(root2);
        if(list1.size()!=list2.size())return false;
        for(int i = 0 ; i < list1.size(); i++){
            if(list1.get(i)!=list2.get(i))return false;
        }
        return  true;
    }
    public ArrayList<Integer> leafList(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root,list);
        return list;
    }
    public void dfs (TreeNode root ,ArrayList<Integer> list){
        if(root==null)return;
        dfs(root.left,list);
        dfs(root.right,list);
        if(root.left==null&&root.right==null)
            list.add(root.val);
    }


}
