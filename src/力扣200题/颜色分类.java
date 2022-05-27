package 力扣200题;

public class 颜色分类 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        //思想类似于快排，在一次遍历中，一直保证 左边 为0 ，中间为 1 ，右边为 2
        // all in [0, zero) = 0
        // all in [zero, i) = 1
        // all in [two, len - 1] = 2
        int i = 0 , zero = 0 ,two = len;
        while (i < two) {
            if(nums[i] == 1) {
                i++;
            } else if(nums[i] == 0) {
                swap(nums,zero,i);
                zero++;
                i++;
            } else {
                two--;
                swap(nums,i,two);
                //这里不要 i++ ,因为交换过来的那个数不一定是  1。
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
