package 排序算法;

public class 归并排序 {
    public static void main(String[] args) {
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
    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = (right + left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, mid + 1, right);
    }

    public static void merge(int[] nums, int left1, int right1, int left2, int right2) {
        int[] t = new int[right2 - left1 + 1];
        int index = 0;
        int temp = left1;
        while (left1 <= right1 && left2 <= right2) {
            if (nums[left1] <= nums[left2]) {
                t[index++] = nums[left1++];
            } else {
                t[index++] = nums[left2++];
            }
        }
        while (left1 <= right1) {
            t[index++] = nums[left1++];
        }
        while (left2 <= right2) {
            t[index++] = nums[left2++];
        }
        for (int i = 0; i < t.length; i++) {
            nums[temp + i] = t[i];
        }
    }
}
