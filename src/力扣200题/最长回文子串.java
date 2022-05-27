package 力扣200题;

import org.junit.Test;

public class 最长回文子串 {


    @Test
    public void test() {
        longestPalindrome("wddaqcabbafqwfaaw");
    }

    /**
     * 和子序列不一样，子串必须是连续的,所以不能使用子序列的方法，使用子序列解法求出来的不是一个连续的子串
     * dp数组的定义：
     * 如果想当前两个字母能在回文子串里面，那么前面的一定是一个回文子串，并且这两个字母相等
     * 而回文子串我们通过subString 原串即可得出
     * baseCase：只有一个的时候为true
     * 状态转移：
     */
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        char[] array = s.toCharArray();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int left = 0 , right = 0;
        for(int i = n - 1 ; i >= 0 ; i--) {
            for(int j = i + 1 ; j < n ; j++) {
                if(s.charAt(i) != s.charAt(j))dp[i][j] = false;
                else {
                    if( j - i < 3){
                        dp[i][j] = true;
                    }
                    else dp[i][j] = dp[i + 1][j - 1];
                }
                if(dp[i][j] && (j - i + 1 > right - left + 1 )) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left , right + 1);
    }
}
