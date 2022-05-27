package 剑指offer;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

public class 剪绳子Ⅱ {

    final static  int MOD = 1000000007;
    @Test
    public void cuttingRope() {
        int n = 120;
        BigInteger[] dp = new BigInteger[n+1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        for(int i = 3 ; i <= n ; i++){
            for(int j = 2 ; j < i ; j++){
                //dp[i] = dp[i].max(dp[i-j].multiply(BigInteger.valueOf(j))).max(BigInteger.valueOf((i-j) * j))  ;
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        System.out.println(dp[n].mod(BigInteger.valueOf(1000000007)).intValue());
    }
    @Test
    public int cuttingRope(int n) {
        if(n < 4){
            return n - 1;
        }
        long res = 1;
        while(n > 4){
            res  = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

}
