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
    public int findMaxForm(String[] strs, int m, int n) {
        int k = strs.length;
        int [][] weight = new int[k][2];
        //先处理strs,转换成对应的重量

        for(int i = 0; i < k ;i++ ) {
            int num0 = 0 , num1 = 0;
            for(char c : strs[i].toCharArray()) {
                if(c == '0')num0++;
                else num1++;
            }
            weight[i][0] = num0;
            weight[i][1] = num1;
        }
        //对于i 个 0 ，j个 1来说，最大的子集数量
        int [][] dp = new int[m + 1][n + 1];

        //dp[i][j] = max(dp[i][j] , dp[i - weight[c][0]][j - weight[c][1]] + 1)
        for(int c = 1 ; c <= k ;c++) {
            for(int i = 1 ; i <= m ; i++) {
                for(int j = n ; j >= weight[c - 1][1] ;j--) {
                    dp[i][j] = Math.max(dp[i][j] , dp[i - weight[c][0]][j - weight[c][1]] + 1);
                }
            }
        }
        return dp[m][n];

    }

}
