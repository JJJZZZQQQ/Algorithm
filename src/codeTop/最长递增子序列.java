package codeTop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 最长递增子序列 {
    // N²
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return dp[length - 1];
    }

    // N * logN 二分 + 贪心
    public int lengthOfLIS2(int[] nums) {
        int length = nums.length;
        //维护一个队列，每次都找到 左侧边界替换掉
        int[] tail = new int[length];
        int res = 0;
        for (int num : nums) {
            //通过二分找到 当前数字 在 tali 中的 左侧边界
            int i = 0,j = res;
            while (i < j) {
                int mid = (i + j) / 2;
                if (num <= tail[mid]) {
                    j = mid;
                } else {
                    i = mid  + 1;
                }
            }
            //l就是左侧边界
            tail[i] = num;
            if(i == res)res++;
        }
        return res;
    }

}
