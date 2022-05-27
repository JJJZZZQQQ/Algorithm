package 代码随想录;

public class 有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int index = res.length - 1;
        while (index >= 0) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[index--] = nums[left] * nums[left];
                left++;
            } else {
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
