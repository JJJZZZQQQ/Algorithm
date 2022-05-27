package 剑指offer;

import org.junit.Test;

public class 丑数 {

    @Test
    public void test() {
        System.out.println(nthUglyNumber(7));
    }
    public int nthUglyNumber(int n) {
        int [] dp = new int[n];
        dp[0] = 1;
        int a = 0,b = 0,c = 0;
        for(int i = 1; i < n;i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(n5,Math.min(n2,n3));
            //为什么这里不是if else if，因为一个dp[i]，有可能一个数有多种组合，比如说 6  ，可以是2 * 3，也可以是3 * 2。
            if(dp[i] == n2)a++;
            if(dp[i] == n3)b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
