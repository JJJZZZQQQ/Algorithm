package leetcode每日一题;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.TreeSet;

public class 模式132 {
    /**
     * 遍历模式中的3，在遍历中维护12
     * 时间复杂度为O(n²)
     */
    public boolean find132pattern1(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int right = nums[2];
        int left = nums[0];
        int mid = nums[1];
        for (int i = 1; i < n; i++) {
            if (left > nums[i - 1]) left = nums[i - 1];
            //这一步可以优化
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i] && nums[j] > left) return true;
            }
        }
        return false;
    }

    @Test
    public void find132pattern2() {
        int[] nums = {1, 2, 3, 4};
        int n = nums.length;
        int left = nums[0];
        int mid = nums[1];
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 2; i < n; i++) {
            treeSet.add(nums[i]);
        }
        for (int i = 1; i < n; i++) {
            if (left > nums[i - 1]) left = nums[i - 1];
            int right = treeSet.ceiling(3);
            if (right < nums[i]) System.out.println("true");
            treeSet.remove(nums[i + 1]);
        }
        System.out.println("false");
    }
}
