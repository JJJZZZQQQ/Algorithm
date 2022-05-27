package 动态规划;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class 最长递增子序列 {

    @Test
    public void test() {
        System.out.println(lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18}));
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int max = 1;
        //注意，初始化有问题，初始化得全部为1才行，因为当一个数是最小的时候，此时dp[i]应该为1而不是0
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                //如果比之前的大
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }

    /**
     * 贪心 + 二分
     * 4,10,4,3,8,9
     */
    public int lengthOfLIS2(int[] nums) {
        int res = -1;
        int[] tail = new int[nums.length];
        //Arrays.fill(tail,Integer.MAX_VALUE);
        for (int target : nums) {
            int left = 0, right = res;
            //利用二分找到目前序列里面比 num 大于等于的第一个数
            int mid = 0;
            while (left <= right) {
                mid = (right - left) / 2 + left ;
                if (tail[mid] < target) {
                    left = mid + 1;
                } else if (tail[mid] >= target) {
                    //判断是不是第一个
                    if (mid == 0 || tail[mid - 1] < target) {
                        break;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            //说明是找到了mid出来的
            if(left <= right) {
                tail[mid] = target;
            }
            //说明没有找到，到了最右边的边界了
            else {
                res++;
                tail[res] = target;
            }
        }
        return res + 1;
    }

}
