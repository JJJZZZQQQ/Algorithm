package 力扣200题;

public class 接雨水 {
    /** 暴力 ：分别求每个格子能放多少水，然后再加起来
     *  每个格子接的水滴数量：min(leftMax , rightMax) - height[i]
     *  左边最高的柱子 和右边最高的柱子 的最小值
     *
     */
    public int trap1(int[] height) {
        int n = height.length;
        int res = 0;
        //注意第一个和最后一个不能算
        for (int i = 1; i < n - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            //求左边的最大值,如果是当前位置为左边最大，说明接的水为0
            for(int j = i - 1 ; j >= 0 ; j--)
                leftMax = Math.max(leftMax,height[j]);
            //求右边的最大值
            for(int j = i + 1 ; j < n ; j++)
                rightMax = Math.max(rightMax,height[j]);
            res += Math.min(leftMax , rightMax) - height[i];
        }
        return res;
    }
    /**
     * 优化一下之前的,求左边最大和右边最大的地方可以不用每次都遍历一次，可以直接维护一个max数组
     * leftMax[i]为 从0 到i之间的最大值
     * 同样 rightMax[j]为从 n - 1 到 j之间的最大值
     */
    public int trap2(int[] height) {
        int n = height.length;
        int [] leftMax = new int[n];
        int [] rightMax = new int[n];
        //baseCase
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i] ,leftMax[i - 1]);
        }
        for(int i = n - 2;i >= 0 ; i--) {
            rightMax[i] = Math.max(height[i] ,rightMax[i + 1]);
        }
        int res = 0;
        //注意第一个和最后一个不能算
        for (int i = 1; i < n - 1; i++) {
            int left = leftMax[i];
            int right = rightMax[i];
            res += Math.min(left , right) - height[i];
        }
        return res;
    }
    /** 可以再优化一下，把空间也优化成O(1) ,根据这道题的特性采用双指针
     * 对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max
     * 这时候，如果left_max < right_max成立，那么它就知道自己能存多少水了
     * 无论右边将来会不会出现更大的right_max，都不影响这个结果
     * 所以当left_max< right_max时，我们就希望去处理left下标
     * 反之，我们希望去处理right下标。
     */
    public int trap3(int[] height) {
        int n = height.length;
        int left = 1 , right = n - 2;
        int leftMax = height[0] , rightMax = height[n - 1];
        int res = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax , height[left]);
            rightMax = Math.max(rightMax , height[right]);
            //处理左边
            if(leftMax < rightMax) {
                res += leftMax - height[left++];
            } else {
                res += rightMax - height[right--];
            }
        }
        return res;
    }
}
