package leetcode每日一题;

public class 解码异或后的数组 {
    public static void main(String[] args) {
        int[] encoded = {1, 2, 3};
        int first = 1;
        int[] nums = new int[encoded.length + 1];
        nums[0] = first;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] ^ encoded[i - 1];
        }
    }
}
