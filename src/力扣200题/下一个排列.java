package 力扣200题;

public class 下一个排列 {

    //如果不存在下一个更大的排列 ，这个时候肯定是倒序的， 将数组左右交换即可
    //从后往前找，找到第一个 前面的数比后面的数 小的数， 然后交换 ，如果一直没找到，就反转数组
    //不行，因为这样交换不能保证刚好是下一个更大的数
    //我们可以保证交换的一定是右边序列的 大于j且最小的数即可 ，而不是直接交换 ，又因为右边的序列降序 ，所以从后往前找到第一个大于的就是最小的
    //当交换完之后还要保证 j之后的数 升序 所以要倒转
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        end:
        for (; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                //小数
                int j = i - 1;
                //此时i 到  end必然为降序 ,找到 这个序列里 第一个大于 j 的数 k
                //
                for (int k = nums.length - 1; k >= i; k--) {
                    if (nums[k] > nums[j]) {
                        int t = nums[j];
                        nums[j] = nums[k];
                        nums[k] = t;
                        break end;
                    }
                }
                //反转数组 从 i 到end
            }
        }
        //反转数组
        int left = i, right = nums.length - 1;
        while (left < right) {
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;
            right--;
        }
    }
}
