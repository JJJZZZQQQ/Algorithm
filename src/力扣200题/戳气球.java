package 力扣200题;

public class 戳气球 {
    public int maxCoins(int[] nums) {
        //如果只有三个气球，那么肯定是戳中间那个气球最大
        //如果左边多了一个气球，那么这时就要选择 1  2  3  4
        //是  1 + 2 * 3 * 4 大  还是 1 * 2 * 3 + 4 大
        int n = nums.length;
        //表示从 i  到  j  的气球序列的最大值 , 这是个开区间
        int[][] dp = new int[n + 2][n + 2];
        int[] point = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            point[i] = nums[i - 1];
        }
        point[0] = 1;
        point[n + 1] = 1;
        for (int i = n + 1; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], point[k] * point[i] * point[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
