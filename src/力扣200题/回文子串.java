package 力扣200题;

public class 回文子串 {
    public int countSubstrings(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] != array[j]) {
                    dp[i][j] = false;
                } else if(j - i <= 2){
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if(dp[i][j])sum++;
            }
        }
        return sum + n;
    }
}
