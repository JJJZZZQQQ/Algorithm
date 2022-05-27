package 动态规划;

public class 让字符串成为回文串的最少插入次数 {
    /**
     * dp[i] [ j ] 的含义：在子串  i 到 j 时，最少的插入次数  ， i往左边增加 ， j往右边增加
     * 初始状态，i = j时 为 0
     */
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //选择
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else {
                    //插i还是插j
                    dp[i][j] = Math.min(dp[i + 1][j] , dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}
