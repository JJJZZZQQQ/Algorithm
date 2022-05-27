package 排序算法;

public class 堆排序x {
    public static void main(String[] args) {
        int[] nums = {3, 2, 10, 3, -1, 3, 0, 6333};
        heapSort1(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void downAdjust1(int[] arr, int parent, int length) {
        //第一个子元素
        int child = parent * 2 + 1;
        //跳出循环的条件是  已经是叶子结点了，或者不需要下沉了。
        while (child < length) {
            //如果有右孩子且右孩子比较大。就让右孩子跟父节点交换
            if (child + 1 < length && arr[child + 1] > arr[child]) child++;
            if (arr[child] <= arr[parent])
                break;
            //交换
            int t = arr[child];
            arr[child] = arr[parent];
            arr[parent] = t;
            //递归下沉
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public static void heapSort1(int[] arr) {
        //构建二叉堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            downAdjust1(arr, i, arr.length);
        }
        //堆排序
        for (int i = arr.length - 1; i > 0; i--) {
            int t = arr[i];
            arr[i] = arr[0];
            arr[0] = t;
            downAdjust1(arr, 0, i);
        }
    }

    /**
     * 下沉操作，执行删除操作相当于把最后
     * * 一个元素赋给根元素之后，然后对根元素执行下沉操作
     *
     * @param arr
     * @param parent 要下沉元素的下标
     * @param length 数组长度
     */
    public static void downAdjust(int[] arr, int parent, int length) {
        //临时保证要下沉的元素
        int temp = arr[parent];
        //定位左孩子节点位置
        int child = 2 * parent + 1;
        //开始下沉
        while (child < length) {
            //如果右孩子节点比左孩子小，则定位到右孩子
            if (child + 1 < length && arr[child] > arr[child + 1]) {
                child++;
            }
            //如果父节点比孩子节点小或等于，则下沉结束
            if (temp <= arr[child])
                break;
            //单向赋值
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }

    //堆排序
    public static void heapSort(int[] arr) {
        //构建二叉堆
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            downAdjust(arr, i, length);
        }
        //进行堆排序
        for (int i = length - 1; i >= 1; i--) {
            //把堆顶的元素与最后一个元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //下沉调整
            downAdjust1(arr, 0, i);
        }
    }
}
