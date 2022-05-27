package 排序算法;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 选择排序 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 10, 3, 2, 3, 0};
        selectionSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /** 选择排序：顾名思义，每次选择一个当前最小的值放到有序数组的尾部
     * 数组结构：有序  +  无序*/
    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[index]) index = j;
            }
            int t = nums[i];
            nums[i] = nums[index];
            nums[index] = t;
        }
    }

    /** 选择排序：顾名思义，每次选择一个当前最大的值放到有序数组的头部
     * 数组结构：无序 + 有序*/
    public static void selectionSort(int[] nums) {
        int length = nums.length;
        for(int i = 0; i < length - 1; i++) {
            int maxIndex = 0;
            for(int j = 0; j < length - i; j++) {
                if(nums[maxIndex] < nums[j]){
                    maxIndex = j;
                }
            }
            int t = nums[maxIndex];
            nums[maxIndex] = nums[length - i - 1];
            nums[length - i - 1] = t;
        }
    }



}
