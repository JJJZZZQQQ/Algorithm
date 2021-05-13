package 排序算法;

import java.util.Queue;

public class 快速排序 {
    public static void main(String[] args) {
        int [] nums = {3,2,1,2,4,2,7,19,-11,0,3};
        quicksort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static  void quicksort(int [] nums,int left,int right){
        //如果left >= right时，说明此时递归的数组长度为1，就不需要操作了
        if(left>=right)return;
        //记录主元的值
        int pivot = nums[left];
        //这一步i的初始值很巧妙，由于主元的值已经记录过了，所以i下标所在的数组
        //数组位置等于一个空的位置，可以用来放其他的数字
        int i = left;
        int j = right;
        while(i<j){
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
        quicksort(nums,left,i-1);
        quicksort(nums,i+1,right);
    }

}
