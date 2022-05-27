package codeTop;

public class 爬楼梯 {
    public int climbStairs(int n) {
        //递归公式
        //dp[n] = dp[n - 2] + dp[n - 1]
        //dp[0] = 1
        int a = 0 , b = 1;
        for (int i = 0; i < n; i++) {
            int t = a + b;
            a = b;
            b = t;
        }
        return b;
    }
}
