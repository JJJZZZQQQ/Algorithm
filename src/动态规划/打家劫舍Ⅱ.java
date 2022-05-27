package 动态规划;

import org.junit.Test;

import java.sql.SQLOutput;

public class 打家劫舍Ⅱ {
    @Test
    /** 从题目的条件：第一个房屋和最后一个房屋是紧挨着的可知，这就是与普通打家劫舍的区别，
     *  那么我们分析这样的条件会带来什么样的结果，此时我们如果偷了第一家，那么最后一家就
     *  一定不能偷了，如果我们偷了最后一家，那么第一家就肯定不能偷了，所以我们把问题拆分
     *  成两个小问题，即偷（1~~n-1）家和偷（2~~n）两种情况，分别求出最大值即可*/
    public void test() {
        int[] nums = {1, 2, 3, 1};
        int[] dp1 = new int[105];
        int[] dp2 = new int[105];
        int max = 0;
        /*if(nums.length==1)return nums[0];*/
        //选1~(n-1)的情况
        dp1[0] = 0;
        dp1[1] = nums[0];
        for (int i = 2; i <= nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i - 1]);
        }
        max = dp1[nums.length - 1];
        //选2~n的情况
        dp2[1] = 0;
        dp2[2] = nums[1];
        for (int i = 3; i <= nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
        }
        max = Math.max(max, dp2[nums.length]);
        System.out.println(max);
    }

    @Test//调用函数解决，增强代码的复用性
    public void test2() {
        int[] nums = {1, 2, 3, 1};
        int n = nums.length;
        if (n == 1) {
            System.out.println(nums[0]);
        } else if (n == 2) {
            System.out.println(Math.max(nums[0], nums[1]));
        }
        System.out.println(Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1)));
    }

    public int robRange(int[] nums, int first, int secend) {
        first = nums[0];
        secend = Math.max(first, nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = secend;
            secend = Math.max(first + nums[i], secend);
            first = temp;
        }
        return secend;
    }
}
