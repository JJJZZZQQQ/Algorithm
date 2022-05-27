package 单调栈;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

public class 下一个更大元素I {
    @Test
    public void test() {
        nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            map.put(nums2[i] , stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
