package 剑指offer;

import org.junit.Test;

public class 股票的最大利润 {

    @Test
    public  void test() {
        int [] a = {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
    public int maxProfit(int[] prices) {
        int res = 0;
        int left = 0, right = 1;
        while (right < prices.length) {
            int t = prices[right] - prices[left];
            if(t > res)res = t;
            if(prices[right] < prices[left])left = right;
            right++;
        }
        return res;
    }
}
