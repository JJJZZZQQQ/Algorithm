package 力扣200题;

public class 跳跃游戏 {
    /**
     * 只要能把所有为0的节点跳过,那么肯定可以到达
     * 为0的节点前面的节点值必须存在大于 下标之差的节点
     * 为0 ，肯定能到
     * 不为0 ，就要考虑
     * dp[i]数组含义为 以i结尾 还能跳的最大值
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if(dp[0] == 0 && n > 1)return false;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] <= 0 && i != n - 1) return false;
        }
        return true;
    }
}
