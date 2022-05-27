package codeTop;

import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    List<List<Integer>> res = new LinkedList<>();
    boolean [] used ;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        dfs(new LinkedList<>(),nums);
        return res;
    }
    public void dfs(LinkedList<Integer> now , int [] nums) {
        if(now.size() == nums.length) {
            res.add(new LinkedList<>(now));
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                used[i] = true;
                now.add(nums[i]);
                dfs(now,nums);
                now.removeLast();
                used[i] = false;
            }
        }
    }
}
