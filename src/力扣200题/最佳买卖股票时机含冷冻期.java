package 力扣200题;

public class 最佳买卖股票时机含冷冻期 {
    /** 我的思路不对，虽然考虑了冷冻期，但是状态并没有保存冷冻期 */
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][prices.length];
        boolean [] flag = new boolean[prices.length + 1];
        dp[0][1] = -prices[0];
        flag[1] = true;
        for (int i = 1; i < prices.length; i++) {
            //持有股票时
            if(flag[i]){
                //今天被冻住了
                dp[i][1] = dp[i - 1][1];
            }
            else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            if (dp[i - 1][0] < dp[i - 1][1] + prices[i]) {
                //今天卖的
                dp[i][0] = dp[i - 1][1] + prices[i];
                //明天不许买
                flag[i + 1] = true;
            } else {
                dp[i][0] = dp[i - 1][0];
            }

        }
        return dp[prices.length - 1][0];
    }
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益 ，今天结束处于冷冻期
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            //前一天持有，或者是今天买入，但是今天买入得考虑前一天不能在冷冻期
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            //今天结束处于冷冻期，肯定是今天卖出的
            f[i][1] = f[i - 1][0] + prices[i];
            //不处于，可以是之前处于冷冻期和非冷冻期的最大值
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

}
