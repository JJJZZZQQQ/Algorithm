package 力扣200题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 组合总和 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new LinkedList<Integer>());
        return res;
    }

    //如何去重呢？
    //排序，规定只能用自己和比自己大的 ，比自己小的和自己一起在之前被加入过了
    public void dfs(int[] candidates, int step, int target, LinkedList<Integer> list) {
        if (target == 0) {
            res.add(new LinkedList<>(list));
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = step; i < candidates.length; i++) {
            if(candidates[i] > target)continue;
            list.addLast(candidates[i]);
            dfs(candidates, i, target - candidates[i], list);
            list.removeLast();
        }
    }
}
