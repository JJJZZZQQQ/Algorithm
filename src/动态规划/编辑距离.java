package 动态规划;

public class 编辑距离 {
    /**
     * basecase是什么？
     * 如果一个字符串为空，那么操作次数就是另一个字符串的长度
     * 如何进行状态选择？
     * 1.插入
     * 2.删除
     * 3.替换
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        //baseCase
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        //进行状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            Math.min(
                                    dp[i - 1][j - 1] + 1 ,//替换
                                    dp[i - 1][j] + 1) , //删除
                                    dp[i][j - 1] + 1   //添加
                    );
                }
            }
        }
        return dp[n][m];

    }
    public int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n == 0|| m == 0)return Math.max(n,m);
        int[] dp = new int[m + 1];
        //baseCase
        for (int i = 0; i <= m; i++) {
            dp[i] = i;
        }
        //进行状态转移
        for (int i = 1; i <= n; i++) {
            int zuoshang = i - 1;
            //dp[0] = i;
            for (int j = 1; j <= m; j++) {
                if (j == 1) {
                    dp[j-1] = i;
                }
                int t = dp[j];
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = zuoshang;
                } else {
                    dp[j] = Math.min(
                            Math.min(
                                    zuoshang + 1 ,//替换
                                    dp[j - 1] + 1) , //删除
                                    dp[j] + 1   //添加
                    );
                }
                zuoshang = t;
            }
        }
        return dp[m];
    }
}
