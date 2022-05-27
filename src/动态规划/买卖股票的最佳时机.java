package 动态规划;

import java.security.PrivateKey;

public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int j = 1 , max = 0;
        while (j < prices.length) {
            if(prices[j] > min) {
                max = Math.max(max,prices[j] - min);
            } else {
                min = prices[j];
            }
            j++;
        }
        return max;
    }
}
