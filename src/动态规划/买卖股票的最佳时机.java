package 动态规划;

import java.security.PrivateKey;

public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        int [] prices = {2,1,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1)return 0;
        int min = prices[0];
        int sum = 0;
        int i = 1;
        while(i<n){
            if(prices[i]<min)min = prices[i];
            sum = Math.max(sum,prices[i]-min);
            i++;
        }
        return sum;
    }
}
