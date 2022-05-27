package 单调栈;

import java.util.Deque;
import java.util.LinkedList;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        //栈里面放索引，因为用索引查值很方便，用值查索引不方便
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while ( !stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
