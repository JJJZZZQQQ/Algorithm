package 动态规划;

public class 买卖股票的最佳时机Ⅲ {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];
        //初始化第一天
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][0][2] = Integer.MIN_VALUE;
        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][1][2] = Integer.MIN_VALUE;
        dp[0][1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //未持有股票，之前也没有卖出过，此时的利益肯定为0
            dp[i][0][0] = 0;
            //未持有股票，但是卖出过一笔，可能是之前卖出的，也可能是今天卖的
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
            //未持有股票，但是卖出过两笔
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);
            //持有股票，没卖出过，可能是今天买的，也可能是之前就买了
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            //持有股票，卖出过一次，只可能是之前卖的，不用考虑，但是可能是今天买的，也可能是之前买的
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
            //持有股票，卖出过两次，这种情况不存在，因为交易完两次之后就不能在买入了,所以设为最小值
            dp[i][1][2] = Integer.MIN_VALUE;
        }
        return Math.max(0, Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));
    }
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int[][][] dp = new int[prices.length][2][3];
        dp[0][0][1] = Integer.MIN_VALUE/2;
        dp[0][0][2] = Integer.MIN_VALUE/2;
        dp[0][1][1] = Integer.MIN_VALUE/2;
        dp[0][1][2] = Integer.MIN_VALUE/2;
        dp[0][1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][1][0] + prices[i]);
            dp[i][0][2] = Math.max(dp[i - 1][0][2], dp[i - 1][1][1] + prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
            dp[i][1][2] = Integer.MIN_VALUE/2;
        }
        return Math.max(0, Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]));
    }
}
