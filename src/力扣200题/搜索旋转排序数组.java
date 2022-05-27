package 力扣200题;

import org.junit.Test;

public class 搜索旋转排序数组 {
    //4,5,6,7,0,1,2
    //有序的，肯定是用二分，思考如何用上二分。
    //只要能把数组分为4,5,6,7  和   0,1,2就能用上二分
    //先用二分找 旋转的位置
    //然后在其中一个数组里二分
    @Test
    public void test() {
        System.out.println(search(new int[]{ 5, 6, 8, 0, 1, 2 , 4}, 1));
    }
    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if(nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        //出来的时候left == right 且就是那个旋转数组的位置 + 1
        //查左边
        int resa = search(nums,target,0,left);
        int resb = search(nums,target,left + 1 , nums.length - 1);
        return resa == resb ? -1 : resa == -1 ? resb : resa;
    }
    public int search(int [] nums , int target, int left , int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
