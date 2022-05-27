package 力扣200题;

public class 完全平凡数 {
    //递推公式
    //dp[i] = dp[i - x] + 1;
    //其中，x为 1 、4、 9、 16 、  25
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for(int j = 1; j * j <= i ; j++) {
                int x = j * j;
                dp[i] = Math.min(dp[i] , dp[i - x] + 1);
            }
        }
        return dp[n];
    }
}
