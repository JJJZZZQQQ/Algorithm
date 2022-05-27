package 单调栈;

import java.util.Deque;
import java.util.LinkedList;

public class 下一个更大元素II {

    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int n = nums.length;
        int [] res = new int[n];
        for(int i = n * 2 - 1 ; i >= 0 ; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
}
