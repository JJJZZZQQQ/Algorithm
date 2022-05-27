package 排序算法;

import org.junit.Test;

import java.util.Queue;
import java.util.Random;

public class 快速排序 {
    @Test
    public void test() {
        int[] nums = {3, 2, 1, 2, 4, 2, 7, 19, -11, 0, 3};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);

        }
    }

    /**
     * 快速排序：利用了分治的思想，
     * 思路：每次都保证左右两边的数组的数字都是在大体正确的位置，此后就不用考虑左右两子数组的关系了
     *      然后再把子数组递归处理。
     * 递归终止：子数组里只有一个数
     * 递归结果：保证传来的数组这一次递归过程执行后主元左边的数都是比主元小的，右边的数都比主元大
     * 递归过程：将主元移动到正确的位置后，左右两子数组分别调用递归函数，由于此时这两个数组都是在正确的位置上
     *          所以当递归到最后时，全部都有序了。
     */
    public void quickSort(int [] nums, int left, int right) {
        if(left >= right)return;
        int partion = nums[left];
        int free = left;
        int i = left;
        int j = right;
        while (i < j) {
            while(i < j && nums[j] >= partion){j--;}
            nums[free] = nums[j];
            free = j;
            while(i < j && nums[i] <= partion){i++;}
            nums[free] = nums[i];
            free = i;
        }
        nums[i] = partion;
        quickSort(nums, left, i - 1 );
        quickSort(nums, i + 1 ,right);
    }
    public void quickSort1(int[] nums, int left, int right) {
        //如果left >= right时，说明此时递归的数组长度为1，就不需要操作了
        if (left >= right) return;
        //记录主元的值
        random_partition(nums, left, right);
        int pivot = nums[left];
        //这一步i的初始值很巧妙，由于主元的值已经记录过了，所以i下标所在的数组
        //数组位置等于一个空的位置，可以用来放其他的数字
        int i = left;
        int j = right;
        while (i < j) {
            //这里一定要先计算j，因为可以直接将j处的值放到i的空位置处
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            //当把j处的值放到空位置处的时候，j处的位置又空了。
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        //把主元放到正确的位置，i和j都可以
        nums[i] = pivot;
        //递归进行移动
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    //随机选取主元
    public void random_partition(int[] nums, int left, int right) {
        int i = left + (int) (Math.random() * (right - left + 1));
        int t = nums[left];
        nums[left] = nums[i];
        nums[i] = t;
    }

}
