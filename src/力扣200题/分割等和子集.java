package 力扣200题;

public class 分割等和子集 {
    /**
     * 状态转移方程
     * dp[i][j] 代表对于前i个数字 ， 容量为 j 时 是否能用这 i 个数字装满
     * 每次容量 + 1的时候，就要考虑是否 能装下 当前的 nums[i-1]这个 数字
     * 不能装下那么直接用以前的 ， 如果能装下再考虑 加一个当前数字 是否能装满
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum /= 2;
        //代表前 i 个 数字 ，容量为 j ,j <= sum
        boolean[][] dp = new boolean[n + 1][sum + 1];
        //容量为 0 的时候， 肯定装满了
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                //如果不能装
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //能装的话就要考虑装了 是不是为 true
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
            if (dp[i][sum]) return true;
        }
        return dp[n][sum];
    }

    public boolean canPartitionYasuo(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 1; j--) {
                if (nums[i - 1] > j) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
            if (dp[sum]) return true;
        }
        return dp[sum];
    }
}
