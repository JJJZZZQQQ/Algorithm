package 动态规划;

public class 零钱兑换II {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        //base case
        for(int i = 0 ; i <= n ;i++){
            dp[i][0] = 1;
        }

        //i 为 前 i 个硬币 ， j 为 总金额
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if(coins[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //为什么这里是 i 而不是 i -  1
                    //由于这里是完全背包，就算我选择了这个地方的零钱，但是我还是可以再选择这里的零钱，所以直接 用i
                    //如果是 0 1 背包的话，选了这里的话就不能选了，所以只能用以前的
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}
