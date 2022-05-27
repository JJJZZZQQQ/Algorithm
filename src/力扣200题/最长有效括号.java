package 力扣200题;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class 最长有效括号 {
    @Test
    public void test() {
        System.out.println(longestValidParentheses(")())"));
    }
    //用栈做
    //不用两层循环，一层就够了
    //题目的特殊性导致的
    public int longestValidParentheses(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        int max = 0;
        Deque <Integer> stack = new LinkedList<>();
        //可以不用处理边界
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if(array[i] == '(') {
                //直接放入即可
                stack.push(i);
            } else {
                stack.pop();
                //如果这时候为空，就代表第一个放进去的虚节点被push出来了，就把这个 ) 当成新的虚节点放进去
                if(stack.isEmpty()) {
                    stack.push(i);
                } else {
                    //就说明此时还是能匹配的
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
