package labuladong的算法小抄;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    @Test
    public void  test() {
        for (List<Integer> integers : permute(new int[]{1, 2, 3})) {
            for (Integer integer : integers) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
    }
    LinkedList<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> integers = new LinkedList<>();
        backtrack(nums,integers);

        integers.add(10);
        return res;
    }
    public void backtrack(int [] nums , LinkedList<Integer> list) {
        if(list.size() == nums.length) {
            res.add(list);
            //res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]))continue;
            list.add(nums[i]);
            backtrack(nums , list);
            //回溯
            list.removeLast();
        }
    }
}
