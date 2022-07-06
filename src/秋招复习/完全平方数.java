package 秋招复习;

import java.util.Arrays;

public class 完全平方数 {
    //还是一样的套路
    /*
    动规问题，我们都应该思考如何进行模型转换
    很明显：此处的平方数是物品，重量为数值的大小，价值为1
    n为背包大小。
    那么这道题经过模型转换之后，就是求装满背包需要的最小物品数量
    1.确定dp数组含义
    2.确定地推共识
    3.确定遍历顺序
    4.初始化
    5.求值
    */
    public int numSquares(int n) {
        //
        int [] weight = new int[101];

        for(int i = 0 ; i < 101 ; i++) {
            weight[i] = i * i;
        }
        //对于容量 n来说，最少需要多少
        int [] dp = new int[n + 1];
        //初始化
        Arrays.fill(dp, Integer.MAX_VALUE/10);
        dp[0] = 0;
        //完全背包
        //先遍历容量
        for(int i = 1 ; i <= n ;i++ ) {
            //再遍历物品
            for(int j = 1 ; j <= 100 && weight[j] <= i ;j++ ) {
                dp[i] = Math.min(dp[i],dp[i - weight[j]] + 1);
            }
        }
        return dp[n];
    }
}
