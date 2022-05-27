package 二分查找;

public class 查找有序不重复数组中的数 {
    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7};
        System.out.println(find(array,3));
    }

    public static int find(int [] array, int target) {
        int left = 0, right = array.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }
}
