package 网易;

import java.util.Scanner;

public class B {
    static int N = 2000001;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int [][] dp = new int[N][2];

        String s1 = scanner.next();
        char[] s = new char[N];
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            s[i] = s1.charAt(i);
        }
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            if(Math.abs(s[i] - s[i - 1] ) <= 1) {
                dp[i][1] = dp[i - 1][0] + (s[i] - 'a' + 1) + (s[i - 1] - 'a' + 1);
            }
        }

        System.out.println(Math.max(dp[n][0] , dp[n][1]));


    }
}
