package 力扣200题;

public class 寻找两个正序数组的中位数 {
    /**
     * 思路：类似归并排序，先把两个数组归并到一个数组。然后直接取中位数
     * 时间复杂度：O(N+M)
     * 空间复杂度：O(N+M)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] array = new int[nums1.length + nums2.length];
        int index = 0;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                array[index++] = nums1[i++];
            } else {
                array[index++] = nums2[j++];
            }
        }
        while (i < n) {
            array[index++]  = nums1[i++];
        }
        while (j < m) {
            array[index++] = nums2[j++];
        }
        if(array.length % 2 == 0) {
            return (array[array.length/2] + array[array.length/2 - 1]) / 2.0;
        } else {
            return array[array.length/2];
        }
    }

    /** 时间复杂度为O(lg(M + N))*/
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        return 0;
    }
}
