package 动态规划;

import org.junit.Test;

public class 买卖股票的最佳时机Ⅱ {
    @Test
    public void Test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitDfs(prices));
    }

    /**
     * 暴力搜索，在每一天，就可以根据当前是否持有股票选择相应的操作
     * 可以什么都不做，如果已经持有就可以卖出，如果还没有持有就可以买入
     * 递归的边界是当天数等于最后一天的时候，此时判断哪种情况利润最大
     */
    private int res;

    public int maxProfitDfs(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        this.res = 0;
        dfs(prices, 0, false, 0);
        return this.res;
    }

    /**
     * @param prices 股价天数
     * @param index  当前天数
     * @param status 此时是否持有股票
     * @param profit 当前总收益
     */
    public void dfs(int[] prices, int index, boolean status, int profit) {
        //递归边界
        if (index == prices.length) {
            res = Math.max(res, profit);
            return;
        }
        //不操作
        dfs(prices, index + 1, status, profit);
        //如果持有，就考虑卖出
        if (status)
            dfs(prices, index + 1, false, profit + prices[index]);
        //如果不持有，就考虑买入
        if (!status)
            dfs(prices, index + 1, true, profit - prices[index]);

    }

    /**
     * 贪心+模拟
     * 只要能赚钱，就都交易，这样确保最后的利润会最大
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int min = prices[0];
        int sum = 0;
        int i = 1;
        /*7,1,5,3,6,4*/
        while (i < n) {
            if (prices[i] <= min) min = prices[i];
            else {
                sum += prices[i] - min;
                min = prices[i];
            }
            i++;
        }
        return sum;
    }

    /**
     * 动态规划
     */
    public int maxProfitDp(int[] prices) {


        return 0;
    }

}
