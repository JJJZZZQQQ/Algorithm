package 剑指offer;

import org.junit.Test;

public class 剪绳子Ⅰ {
    /** 递归公式  f(n) = Max(  f(n-i) * f(i) )
        递推公式 dp[i] = Math.max(dp[i] , Math.max( dp[i-j] * j , j * (i - j) ) )
     */
    @Test
    public void cuttingRope() {
        int n = 10;
        int [] dp = new int [n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3 ; i <= n ; i++){
            for( int j = 2 ; j < i ; j++ ){
                dp[i] = Math.max(dp[i] , Math.max( dp[i-j] * j , j * (i - j) ) );
            }
        }
        System.out.println(dp[n]);
    }

    @Test
    public int cuttingRope2() {
        int n = 120;

        if(n <= 3)return n-1;
        else {
            int a = n / 3;
            int b = n % 3;
            if(b == 0 )
                return (int) Math.pow(3,a);
            else if(b == 1)
                return (int)Math.pow(3,a - 1) * 4;
            else
                return (int)Math.pow(3,a) * 2;
        }

    }
}
