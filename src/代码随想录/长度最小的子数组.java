package 代码随想录;

public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        //可以滑动窗口，如果小了就往右滑，大了往左滑
        int left = 0, right = -1;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (++right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
