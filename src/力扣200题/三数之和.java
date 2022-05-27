package 力扣200题;

import org.junit.Test;

import java.util.*;

public class 三数之和 {
    //暴力：找出所有的三个数的排列组合，看满不满足条件
    //时间复杂度：n的三次方
    //

    // -4  -1  -1  0  1  2
    @Test
    public void test() {
        List<List<Integer>> list = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list.size());
    }

    //对于一组解 a ，b c ， 可以有三种重复的情况
    //如何只取一种呢？ 让 a b c 有序即可，所以left和right要从 当前位置的后面开始
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //说明后面的都要大，肯定不可能了
            if(nums[i] > 0)break;
            //如果nums里面有重复的，就不能再用一次了，因为出来的结果肯定会有重复的
            if (i != 0 && nums[i] != nums[i - 1])continue;
            int cha = -nums[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] < cha) {
                    left++;
                } else if (nums[left] + nums[right] > cha) {
                    right--;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    //这里还要去重，因为如果下一个left 或者是下一个right 这个时候那么结果也会有重复的
                    while (left < right && nums[left + 1] == nums[left])left++;
                    while (left < right && nums[right - 1] == nums[right])right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
