package 动态规划;

import org.junit.Test;

public class anmoshi {
    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 1};
        int n = nums.length;
        if (n == 0) System.out.println(0);
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        System.out.println(dp[n]);
    }

    @Test
    public void test2() {//优化空间版
        int[] nums = {1, 2, 3, 1};
        int n = nums.length;
        if (n == 0) System.out.println(0);
        int left = 0, right = nums[0];
        for (int i = 2; i <= n; i++) {
            int t = right;
            right = Math.max(left + nums[i - 1], right);
            left = t;
        }
        System.out.println(right);
    }

}
