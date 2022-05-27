package 剑指offer;

import java.util.HashSet;

/**
 * 这题有三种方法：
 * 1.HashSet
 * 2.原地交换，利用数组里的数字范围为 1到 n - 1的特性
 * 3.二分法
 */
public class 数组中重复的数字 {
    /**
     * 原地交换
     * 数字都在 0 到 n - 1
     * 下标都在 0 到 n - 1
     * 如果重复了，那么一个下标就对应了多个数字
     * 所以我们把数字都放到相应的下标里面
     * 如果放进去的时候发现下标和值已经对应了，就说明重复了
     */
    public int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; ) {
            //当前位置是对应的
            if(nums[i] == i){
                i++;
                continue;
            }
            //当前位置不对应，要移动元素，但是发现相等，就说明重复了
            if(nums[i] == nums[nums[i]])return nums[i];
            //交换 nums[i] 和 nums[nums[i]]
            int t = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = t;
            //此时i 位置的元素就是 nums[nums[i]]的元素，进行下一次判断
        }
        return -1;
    }
}
