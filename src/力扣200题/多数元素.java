package 力扣200题;

public class 多数元素 {
    public int majorityElement(int[] nums) {
        int now = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                now = nums[i];
                continue;
            }
            if (nums[i] == now) count++;
            if (nums[i] != now) {
                count--;
            }
        }
        return now;
    }
}
