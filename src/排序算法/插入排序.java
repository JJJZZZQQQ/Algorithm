package 排序算法;

public class 插入排序 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 10, 3, -1, 3, 0};
        insertionSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    /**
     * 插入排序：顾名思义，把一个个数插到有序数组中，维护一个有序数组
     * 思路：从第二个数开始往前插，直到第一个比当前数小于或者等于的数就停下来
     * 插的时候要把之前的数往后移一位，才能插进去
     * 数组结构：有序  +  无序
     */
    public static void insertionSort(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int t = nums[i];
            while (j >= 0 && nums[j] > t) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = t;
        }
    }
}
