package 二分查找;

public class 查找第一个值等于给定值的元素 {
    public static void main(String[] args) {
        int [] array = {1,2,2,2,3,3,4,5,6,7};
        System.out.println(find(array,2));
    }

    public static int find(int [] array, int target) {
        int left = 0, right = array.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(array[mid] == target) {
                //要判断是不是第一个等于给定值的元素
                if(mid == 0 || array[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }
}
