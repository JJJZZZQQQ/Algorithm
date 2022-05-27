package 动态规划;

public class 最长公共子序列问题 {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] dp = new int[m + 1];
        for(int i = 1 ; i <= n;i++) {
            int t = 0;
            int upLeft = 0;
            for(int j = 1; j <= m ; j++) {
                //用一个值 先暂存 i-1 ， j-1
                t = dp[j];
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = upLeft + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1],dp[j]);
                }
                //把i - 1 ，j -1 也就是上左更新到upLeft
                upLeft = t;
            }
        }
        return dp[m];
    }
}
