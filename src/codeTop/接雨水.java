package codeTop;

import org.junit.Test;

public class 接雨水 {
    /** 思路：我们只要能算出每一列最多能接多少水，然后加起来就行了
     * 每一列的水等于min(左区间,右区间)
     * 先把最小值算出来
     */
    public int trap(int[] height) {
        int length = height.length;
        // 0 到 i 的最大值
        // i 到 length - 1的最大值
        int [] left = new int[length];
        int [] right = new int[length];
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            a = Math.max(a, height[i]);
            left[i] = a;
            b = Math.max(b,height[length - i - 1]);
            right[length - i - 1] = b;
        }
        for (int i : left) {
            System.out.print(i+",");
        }
        System.out.println();
        for (int i : right) {
            System.out.print(i+",");
        }
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(left[i],right[i]) - height[i];
        }
        return res;
    }
}
