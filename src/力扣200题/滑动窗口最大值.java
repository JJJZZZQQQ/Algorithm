package 力扣200题;

import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        int [] res = new int[nums.length - k + 1];
        res[0] = deque.getFirst();
        for(int i = k ; i < nums.length ;i++) {
            if(nums[i - k] == deque.getFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.getFirst();
        }
        return res;
    }
}
