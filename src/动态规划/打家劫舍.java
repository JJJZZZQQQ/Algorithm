package 动态规划;

import com.sun.org.apache.xpath.internal.axes.DescendantIterator;
import jdk.management.resource.ResourceType;
import org.junit.Test;

public class 打家劫舍 {
    @Test
    public void tset1() {
        int[] nums = {1, 2, 3, 1};
        int[] dp = new int[100];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        System.out.println(dp[nums.length]);
    }

    @Test//使用滚动数组优化空间,一直维护数组前俩位即可,因为递推式里最多只要用到dp[i-2];
    public void test2() {
        int[] nums = {1, 2, 3, 4};
        int first, secend;
        first = nums[0];
        secend = Math.max(first, nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = secend;
            secend = Math.max(first + nums[i], secend);
            first = temp;
        }
        System.out.println(secend);
    }
}
