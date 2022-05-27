package codeTop;

public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int max = nums[0] , sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(sum < 0) {
                sum = nums[i];
                max = Math.max(max,sum);
            } else {
                sum += nums[i];
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}
