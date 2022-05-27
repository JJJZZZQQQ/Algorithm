package 剑指offer;

import org.junit.Test;

public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        //永远指向第一个偶数
        int low = 0;
        //往下遍历
        int high = 0;
        while(high < nums.length){
            if(nums[high] % 2 == 0){
                high++;
            }
            else {
                int t = nums[high];
                nums[high] = nums[low];
                nums[low] = t;
                low++;
                high++;
            }
        }
        return nums;
    }
    @Test
    public  void main() {
        int [] nums = {1,2,3,4};
        for (int n : exchange(nums)) {
            System.out.println(n);
        }
    }
}
