package TME;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class A {
    /**
     * n : 字符串长度
     * k : k个连续段
     */
    int[][] dp = new int[10000][10000];
    final int MOD = 1000000;

    public int numsOfStrings(int n, int k) {
        // write code here
        //每个连续段里的都可以换
        // res = k * 26
        //res 为 全部为 a的时候的个数
        int m = n + k;
        for (int i = 0; i <= m; i++) {
            dp[i][0] = dp[i][i] = 1;
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        return 0;
    }

    public int minMax1(ArrayList<Integer> a, int k, int x) {
        // write code here
        int n = a.size();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = a.get(i);
        }
        while (k > 0) {
            Arrays.sort(array);
            //直接减到比第二大的值小
            int i = array[n - 1];
            int j = array[n - 2];
            int cha = i - j;
            int num = cha / x + 1;
            if (k >= num) {
                k -= num;
            } else {
                num = k;
                k = 0;
            }

            array[n - 1] -= (x * num);
        }
        Arrays.sort(array);
        return array[n - 1];
    }

    @Test
    public void test() {
        System.out.println(minCnt("111"));
    }

    public int minCnt(String s) {
        // write code here
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                int cnt = 0;
                for (int j = i + 1; j < n; j++) {
                    if (s.charAt(j) == '1') {
                        cnt++;
                    }
                }
                sum = i + cnt;
                break;
            }
        }
        return sum;
    }
}
