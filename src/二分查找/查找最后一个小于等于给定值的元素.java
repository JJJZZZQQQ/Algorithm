package 二分查找;

import java.util.HashSet;

public class 查找最后一个小于等于给定值的元素 {
    public static void main(String[] args) {
        int [] array = {1,2,2,2,2,3,3,5,6,7};
        System.out.println(find(array,4));
    }

    public static int find(int [] array, int target) {
        int left = 0, right = array.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (array[mid] <= target) {
                //判断是不是最后一个
                if(mid == array.length - 1 || array[mid + 1] > target) {
                    return mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }
}
