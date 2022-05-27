package leetcode每日一题;

import java.util.Arrays;

public class K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0, min = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0 && nums[i] < min) min = nums[i];
            if (k > 0 && nums[i] <= 0) {
                nums[i] = -nums[i];
                sum += nums[i];
                k--;
            } else {
                sum += nums[i];
            }
        }
        if(k != 0 && k % 2 == 0) {
            return sum;
        } else if(k != 0 && k % 2 == 1) {
            Arrays.sort(nums);
            return sum - nums[0] * 2;
        } else {
            return sum;
        }
    }
}
