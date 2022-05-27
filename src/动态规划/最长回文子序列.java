package 动态规划;

import org.junit.Test;

import java.util.Arrays;

public class 最长回文子序列 {

    @Test
    public void test() {
        System.out.println(longestPalindromeSubseq2("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n ][n ];
        //初始化有问题，并不是所有的都为1，只有i和j的为同一个位置的时候才为1。
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        char[] array = s.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            //为什么此处的j从i + 1开始，因为 j = i的时候已经在base case里面了，而i > j的情况，都不满足dp数组的要求
            //左边界超出了右边界了
            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        int[] dp = new int[n ];
        //初始化有问题，并不是所有的都为1，只有i和j的为同一个位置的时候才为1。
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        char[] array = s.toCharArray();
        for (int i = n - 2; i >= 0; i--) {
            int leftDown = 0;
            int t = 0;
            for (int j = i + 1; j < n; j++) {
                t = dp[j];
                if (array[i] == array[j]) {
                    dp[j] = leftDown + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                leftDown = t;
            }
        }
        return dp[n - 1];
    }
}
