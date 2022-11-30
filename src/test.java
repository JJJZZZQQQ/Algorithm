

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class test {


    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (Integer integer : list) {
            list.remove(integer);
        }
    }

    public int integerBreak(int n) {
        int [][] dp = new int[n + 1][n + 1];

        for(int i = 0 ; i<= n ;i++) {
            for(int j = 0 ; j <= 0 ;j++) {
                dp[i][j] = 1;
            }
        }

        for(int i = 1 ; i<= n ;i++) {
            for(int j = 2 ; j <= n ;j++) {
                if( j - i >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] * i);

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][n];
    }
}

