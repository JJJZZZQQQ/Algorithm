package 剑指offer;

public class 到n1中缺失的数字 {
    public int missingNumber(int[] nums) {
        int i = 0;
        for (; i < nums.length; i++) {
            if(i != nums[i])return i;
        }
        return i;
    }
    public int missingNumberEr(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if(nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public int missingNumber12(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

}
