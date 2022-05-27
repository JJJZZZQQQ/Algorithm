package 动态规划;

import org.junit.Test;

import java.util.Arrays;

/** ：envelopes = [[5,4],[6,4],[6,7],[2,3]] */
public class 俄罗斯套娃信封问题 {

    @Test
    public void test() {
        System.out.println(maxEnvelopes2(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    /** dp数组表示 当前信封在最外层时，里面还能放几个
     *  简单的比较两个状态转移方程不行*/
    public int maxEnvelopes(int[][] envelopes) {
        int [] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        Arrays.sort(envelopes,(a,b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int max = 1;
        for(int i = 1 ; i < envelopes.length ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }
    public int maxEnvelopes2(int[][] envelopes) {
        int [] tail = new int[envelopes.length];
        Arrays.sort(envelopes,(a,b) -> {
            return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        int res = 0;
        for (int[] envelope : envelopes) {
            int left = 0,right = res;
            while ( left < right) {
                int mid = (left + right) / 2;
                if(tail[mid] >= envelope[1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            tail[left] = envelope[1];
            if(left == res)res++;
        }
        return res;
    }
}
