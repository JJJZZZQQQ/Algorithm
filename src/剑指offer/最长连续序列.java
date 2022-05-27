package 剑指offer;

import org.junit.Test;

import java.util.Arrays;

public class 最长连续序列 {

    @Test
    public void test() {
        System.out.println(longestConsecutive(new int[]{0,1,1,2}));
    }
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1;
        int now = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[i - 1] == 1) {
                now++;
            } else if(nums[i] != nums[i-1]){
                now = 1;
            }
            if(now > max)max = now;
        }
        return max;
    }
}
