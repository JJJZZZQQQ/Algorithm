package labuladong的算法小抄;

import org.junit.Test;

import java.util.Stack;

public class 单调栈模板 {
    @Test
    public void test() {
        nextGreaterElements(new int[]{5,1,2,4,3});
    }
    /** 什么样的问题适合使用单调栈的问题？
     *  当题目出现   找到最近一个比其大的元素 时，一般就是使用单调栈。
     * */
    public int[] nextGreaterElements(int[] nums) {
        int [] res = new int[nums.length];
        //栈中递减，栈头最小
        Stack<Integer> stack = new Stack<>();
        //从后往前入栈
        for (int i = nums.length - 1; i >= 0; i--) {
            //栈里面此时的元素都是在当前元素之后的，因为是从后往前加进去的
            //当栈头比 目标值 nums[i] 小的时候，就弹出
            //为什么这里可以直接弹出？
            //借鉴 最大栈这道题的思想，由于后进栈的元素相比栈中原来的元素，位置都排在数组的前方
            //所以只要后进栈的比之前的大于等于，那么这个后进栈的元素就可以取代旧的元素。
            while( !stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            //如果栈里面有值，那么肯定栈头就是第一个比当前目标值大的
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
