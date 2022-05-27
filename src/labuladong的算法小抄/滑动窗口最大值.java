package labuladong的算法小抄;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口最大值 {
    @Test
    public void test() {
        maxSlidingWindow(new int[] {1,3,1,2,0,5} , 3);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)return new int[0];
        int [] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        //base case

        for(int i = 0 ; i < k ; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for(int i = k ; i < nums.length ; i++) {
            //先缩左窗口
            if(deque.peekFirst() == nums[i - k])
                deque.pollFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }

        return res;
    }
}
