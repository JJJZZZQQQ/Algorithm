package labuladong的算法小抄;

import java.util.Arrays;

public class 零钱兑换322 {

    /** 边界：dp[0] =  0
     * 状态转移方程
     * if amount < coin 说明这枚硬币比 总金额还要大，那肯定拿不起 ,dp[i] = dp[i-1] + 1
     * if amount >= coin 说明这枚硬币可以拿,考虑需不需要拿，如果比之前需要的硬币数都少，就要拿, dp[i] = min(dp[i - coin] + 1, dp[i])
     * */
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        //初始化数组的值，因为是求最小值，需要初始化一个比所有可能性大的值
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        //开始从 1 到 amount计算 dp数组
        for (int i = 1; i <= amount ; i++) {
            for (int coin : coins) {
                if(coin > i)continue;
                dp[i] = Math.min(dp[i - coin] + 1 , dp[i]);
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];

    }
}
