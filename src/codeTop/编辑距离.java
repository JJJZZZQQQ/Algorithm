package codeTop;

public class 编辑距离 {
    //两个字符串的题，一般都需要一个二维的DP数组
    //dp[ i ][ j ]的含义代表 word1 从 0 到 i ， word2 从0 到 j 两个子字符串的最小编辑距离
    //BaseCase 当一个子字符串的长度为0时，最小编辑距离就是另一个子字符串的长度
    //状态选择时，对word1进行如下操作时
    // 插入 j - 1
    // 删除 i - 1
    // 修改 i 和 j 同时 - 1
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
