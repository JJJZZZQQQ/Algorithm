package 剑指offer;

import sun.util.resources.cldr.ga.TimeZoneNames_ga;

public class 和为s的两个数字 {

    /** nums = [2,7,11,15], target = 9*/
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int index = find(nums, target - nums[i], i, nums.length);
            if(index >= 0) {
                return new int[] {nums[index], nums[i]};
            }
        }
        return null;
    }
    /** 通过二分查找在有序的数组中查找target*/
    public int find(int [] nums, int target,int left, int right) {
        while(left <= right) {
            int mid = (left + right) / 2 ;
            if(nums[mid] == target)return mid;
            else if(nums[mid] < target)left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /** 如果小了，要不就让i++,要不就要j++，j++的话，这一组数之前已经遍历过了，肯定还是小了，所以让i++
     *  如果大了，要不就让i--，要不就让j-- ，i--没有意义，所以让j--*/
    public int[] twoSumByTijie(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }



}
