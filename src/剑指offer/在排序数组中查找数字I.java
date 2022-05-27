package 剑指offer;

import org.junit.Test;

public class 在排序数组中查找数字I {

    @Test
    public void test (){
        System.out.println(search(new int[]{2, 2}, 2));
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0 )return 0;
        int i = 0, j = n - 1;
        int up = -1;
        int down = 0;
        int mid = 0;
        //二分找下界
        while (i <= j) {
            //以后有移位的都带上括号
            mid = ((j - i) >> 1)  + i;
            if(nums[mid] > target) {
                j = mid - 1;
            }  else if(nums[mid] < target){
                i = mid + 1;
            } else {
                if ((mid == 0) || (nums[mid - 1] != target)) {
                    break;
                }
                else {
                    j = mid - 1;
                }
            }
        }
        if(nums[mid] != target)return 0;
        down = mid;
        //二分找上界
        i = 0 ;
        j = n - 1;
        while (i <= j) {
            mid = (j - i) >> 1 + i;
            if(nums[mid] < target) {
                i = mid + 1;
            }  else if(nums[mid] > target){
                j = mid - 1;
            } else {
                if ((mid == n - 1) || (nums[mid + 1] != target)) {
                    break;
                }
                else {
                    i = mid + 1;
                }
            }
        }
        up = mid;
        if(nums[up] == target || nums[down] == target) return up - down + 1;
        else return  0 ;
    }
}
