package 排序算法;

import org.junit.Test;

public class 归并排序2 {

    @Test
    public void test() {
        int[] nums = {3, 2, 10, 3, -1, 3, 0};
        mergeSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    /**
     * 归并排序：利用了分治的思想从单个的开始归并，只要保证归并时候有序，那么最终的数组也有序
     * 思路：递归
     * 递归终止：子数组里只有一个数
     * 递归结果：保证传来的数组这一次递归过程执行后有序
     * 递归过程：左右两数组分别调用递归函数，然后把传回来的两个数组按序合并到一个数组
     * 由于这两个数组有序，又是按序合并的，所以最终结果也有序
     */
    public void mergeSort(int[] nums, int left, int right) {

    }

    public void merge(int[] nums, int left1, int right1, int left2, int right2) {

    }
}
