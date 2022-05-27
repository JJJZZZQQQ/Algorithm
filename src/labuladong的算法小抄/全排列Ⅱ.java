package labuladong的算法小抄;

import org.junit.Test;

import java.util.*;

public class 全排列Ⅱ {
    @Test
    public void  test() {
        for (List<Integer> integers : permuteUnique(new int[]{1, 1, 2})) {
            for (Integer integer : integers) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
    }
    LinkedList<List<Integer>> res = new LinkedList<>();
    boolean [] flag ;

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> integers = new LinkedList<>();
        flag = new boolean[nums.length];
        backtrack(nums,integers);
        return res;
    }
    public void backtrack(int [] nums , LinkedList<Integer> list) {
        if(list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        //用来剪枝
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(flag[i])continue;
            //使用
            if(set.contains(nums[i]))continue;
            flag[i] = true;
            list.add(nums[i]);
            backtrack(nums , list);
            //回溯
            list.removeLast();
            flag[i] = false;
            set.add(nums[i]);
        }
    }

}
