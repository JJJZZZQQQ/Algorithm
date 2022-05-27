package 力扣200题;

import org.junit.Test;

public class 乘积最大子数组 {

    @Test
    public void test() {
        maxProduct(new int[] {-4,-3,-2});
    }
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int t = imax;
                imax = Math.max(nums[i], nums[i] * imin);
                imin = Math.min(nums[i], nums[i] * t);
            } else {
                imax = Math.max(nums[i], nums[i] * imax);
                imin = Math.min(nums[i], nums[i] * imin);
            }
            max = Math.max(max, imax);
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            System.out.println(imax+"-----"+imin);
            max = Math.max(max, imax);
        }
        return max;
    }

}
