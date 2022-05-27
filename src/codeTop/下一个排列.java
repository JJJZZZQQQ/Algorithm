package codeTop;

import java.util.Arrays;

public class 下一个排列 {
    /**
     * 下一个更大的排列
     * 由于数字的特性，移动末尾的数字对整体的大小影响比较小
     * 我们从最后一个数字开始从后往前遍历，找到第一个比该数字小的数字，然后交换
     * PS:此处找到i , j的思路可以优化一下
     * 我们只需要找到 i，也就是第一个不满足降序的数字
     * 由于i + 1 到 end 这个区间的数肯定都是降序的
     * 所以我们只需要在这个降序区间里面从后往前找到第一个大于 nums[i]的数，就是要交换的数了
     *
     * 然后保证交换之后的后半部分数字升序排列即可，也就是保证 i + 1 到 end 这个区间升序
     * 前面已知是降序的，所以只要翻转 i + 1 到end 即可
     * 1,2,3 就是 1,3,2
     * 1,3,2 就是 2,1,3
     */
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int j = length - 1;
        end:
        for (; j > 0; j--) {
            if (nums[j - 1] < nums[j]) {
                int i = j - 1;
                // i , j
                //此时i后面的所有数都是降序排列的
                //我们只要从后往前找到第一个大于i的数作为我们交换的位置即可
                for (int k = length - 1; k >= j; k--) {
                    if(nums[k] > nums[i]) {
                        int t = nums[k];
                        nums[k] = nums[i];
                        nums[i] = t;
                        break end;
                    }
                }
            }
        }
        //交换的时候，i之后的数组必然降序，要变成升序只要翻转即可
        int left = j, right = length - 1;
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
}
