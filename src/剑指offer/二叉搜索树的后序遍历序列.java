package 剑指offer;

import org.junit.Test;

public class 二叉搜索树的后序遍历序列 {

    @Test
    public void test() {
        System.out.println(verifyPostorder(new int[]{3, 10, 6, 9, 2}));
    }

    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    /**
     * 数组只有一个时返回
     * 找到左右子树的分界点x
     * <p>
     * 然后对(0,x - 1) ( x , length - 2 ) 递归判断
     */
    public boolean dfs(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int x = right;
        boolean flag = false;
        for (int i = left; i < right; i++) {
            if (postorder[i] > postorder[right]) {
                if(flag == false)
                    x = i;
                flag = true;
            }
            //找到x之后的所有数都要大于根节点
            else if (flag) {
                return false;
            }
        }
        return dfs(postorder, left, x - 1) && dfs(postorder, x, right - 1);
    }
}
