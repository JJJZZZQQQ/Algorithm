package 力扣200题;

public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int[] b = new int[nums.length];
        //先算下半部分
        b[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            b[i] = b[i - 1] * nums[i - 1];
        }
        //再算下半部分
        int t = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            t *= nums[i + 1];
            b[i] = b[i] * t ;
        }
        return b;
    }
}
