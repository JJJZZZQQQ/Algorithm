package 排序算法;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 选择排序 {
    public static void main(String[] args) {
        int [] nums = {3,2,10,3,2,3,0};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static  void sort(int [] nums){
        int n = nums.length;
        for(int i = 0 ; i <n-1 ; i++){
            int index = i;
            for(int j = i+1 ; j < n ; j++){
                if(nums[j]<nums[index]) index = j;
            }
            int t = nums[i];
            nums[i] = nums[index];
            nums[index] = t;
        }
    }
}
