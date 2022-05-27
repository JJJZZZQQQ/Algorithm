package 力扣200题;

import org.junit.Test;

import java.util.*;

public class 子集 {
    @Test
    public void test(){
        subsets(new int[]{1,2,3});
    }

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    /** 对于最后的答案，每个元素在答案里的情况只有两种，一种是存在，一种是不存在，一共有2
     *  的n方个答案，所以，我们只要每次递归的时候把选和不选这两种情况都往下递归就行了*/
    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
