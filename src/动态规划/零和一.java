package 动态规划;

public class 零和一 {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        //m是0，n是1,
        int m = 5, n = 3;
        int[][] dp = new int[n + 1][m + 1];
        for (String str : strs) {
            int v0 = 0;
            int v1 = 0;
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                if (c == '0') v0++;
                else v1++;
            }//01背包从后往前递推,完全背包才是从前往后递推
            for (int i = n; i >= 0; i--) {
                for (int j = m; j >= 0; j--) {
                    if (i - v1 >= 0 && j - v0 >= 0) {
                        dp[i][j] = Math.max(dp[i - v1][j - v0] + 1, dp[i][j]);
                    }
                }
            }
        }
        System.out.println(dp[n][m]);

    }
}
