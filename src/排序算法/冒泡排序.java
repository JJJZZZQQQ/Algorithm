package 排序算法;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 10, 3, -1, 3, 0};
        //sort(nums);
        bubbleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    /**
     * 冒泡排序：顾名思义，把当前最大的数冒泡（移动到最前面）
     * 思路：遍历数组，每次进行比较，让前面的比后面的大，一直把最大的移到length-1-i即无序数组的尾部(第一次就是放在最后一个，第二次放在倒数第二个)的位置上
     * 数组结构：无序 + 有序
     */
    public static void bubbleSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            boolean flag = false;
            for (int j = 1; j < length - i; j++) {
                if(nums[j - 1] > nums[j]) {
                    int t = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = t;
                    flag = true;
                }
            }
            if(!flag)break;
        }
    }

}
