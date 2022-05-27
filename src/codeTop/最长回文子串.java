package codeTop;

public class 最长回文子串 {

    public String longestPalindrome(String s) {
        int length = s.length();
        char[] array = s.toCharArray();
        //表示从 i 到 j这个子字符串是否是回文串
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        int left = 0, right = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] == array[j] && (dp[i + 1][j - 1] || j - i < 2)) {
                    dp[i][j] = true;
                    if (j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

}
