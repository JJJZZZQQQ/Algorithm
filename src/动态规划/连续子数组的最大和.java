package 动态规划;

import org.junit.Test;

public class 连续子数组的最大和 {
    @Test
    /**2021 4月我的解法,为什么不对，因为数组里有负值，所以不管怎么样sum都得先赋值。*/
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > 0) sum += nums[i];
            else sum = 0;
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    @Test
    public void test1() {//正解
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) max = sum;
            if (sum < 0) sum = 0;
        }
        System.out.println(max);
    }

    /** 2021 10 月 贪心*/
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(sum < 0)sum = nums[i];
            else sum += nums[i];
            if(max < sum)max = sum;
        }
        return max;
    }
    /** 动态规划 :
     * 边界 dp[0] = nums[0]
     * 递推公式：dp[n] = max(dp[n-1] + nums[n],dp[n])*/
    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] +=
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
