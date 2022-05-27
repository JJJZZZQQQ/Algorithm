package 动态规划;

import java.util.Arrays;

public class 最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1 ; i < nums.length;i++) {
            if(nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            if(max < dp[i])max = dp[i];
        }
        return max;
    }
}
