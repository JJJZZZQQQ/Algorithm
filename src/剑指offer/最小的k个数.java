package 剑指offer;

import java.util.Arrays;

/**
 * 快排：时间复杂度O(n * lg(n)) 空间复杂度 O(1)
 * 堆排：时间复杂度O(n * lg(n)) 空间复杂度 O(k)
 */
public class 最小的k个数 {


    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void quickSort(int[] arr, int left, int right, int k) {
        if (left >= right) return;
        //选取主元
        int partion = arr[left];
        int free = left;
        //使主元去到正确的位置，即主元左边的一定比主元小，主元右边的一定比主元大
        int i = left, j = right;
        while (i < j) {
            //找到右边第一个小于主元的数，放到左边去，同时free变成右边这个位置
            while (i < j && arr[j] >= partion) {
                j--;
            }
            arr[free] = arr[j];
            free = j;
            //找到右边第一个大于主元的数，放到右边的free去，同时free变成左边的空闲位置
            while (i < j && arr[i] <= partion){
                i++;
            }
            arr[free] = arr[i];
            free = i;
        }
        arr[i] = partion;
        //说明前n个位置已经是最小的k个数了
        if(i == k) {
            return;
        }
        //说明i之前就已经有k个数了，右区间就不需要递归了
        else if(i > k) {
            quickSort(arr, left, i - 1, k);
        }
        //说明这个主元左边的数不够k个，继续递归右区间
        else {
            quickSort(arr, i + 1, right, k);
        }
    }
}
