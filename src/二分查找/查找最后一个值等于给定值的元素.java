package 二分查找;


/** 王争老师的二分与东哥的二分的区别：
 * 王争老师的二分区间是左闭右闭的
 * 而东哥的二分区间是左闭右开的
 * 这就造成了两者在二分移动左右边界的不同之处
 *
 * */
public class 查找最后一个值等于给定值的元素 {
    public static void main(String[] args) {
        int [] array = {1,2,2,2,2,3,3,4,5,6,7};
        System.out.println(find2(array,-1));
    }

    public static int find(int [] array, int target) {
        int left = 0, right = array.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(array[mid] == target) {
                //判断当前这个 mid 是不是最后一个等于目标值的
                if(mid == array.length - 1 || array[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;

    }

    public static int find2(int [] array, int target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if(array[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if(left == 0);
        return left - 1;
    }
}
