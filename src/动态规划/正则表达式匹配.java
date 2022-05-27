package 动态规划;

public class 正则表达式匹配 {
    /**
     * dp[i][j] 表示 s0 - si  和 p0 到 pj 是否能匹配
     * baseCase ：dp[0][x] = true
     * 状态转移：
     * if p[j] == . ，那么dp[i][j] = dp[i - 1][j]
     * if p[j] == s[j] 那么dp[i][j] = dp[i - 1][j - 1]
     * if p[j] == * ,
     * if p[j - 1] == s[j] ,dp[i][j] = dp[i - 1][j]
     * else dp[i][j] = false;
     * else dp[i][j] = false
     * dp[i][j]
     */
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        char[] s1 = s.toCharArray();
        char[] p1 = p.toCharArray();
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            dp[0][m] = true;
        }
        //存在的问题，j不能从1开始，但是如果从 i 开始的话那么又 没有考虑到 * 的情况
        //主要就是要处理  *
        //而如何处理 * 呢
        //首先 分几种情况
        //  p[j-1] != s[i] && p[j - 1] != '.' : dp[i][j] = dp[i][j-2] *  前面那个字母不相等的话，就等于匹配 0 个
        // p[j - 1] = s[i] || p[j - 1] ='.' 可以匹配，只要看前面的是否匹配  dp[i][j] = dp[ i - 2 ][ j - 1]
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1[i - 1] == p1[j - 1] || p1[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p1[j - 1] == '*') {
                    if (s1[i - 1] == p1[j - 2] || p1[j - 2] == '.') dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = false;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
