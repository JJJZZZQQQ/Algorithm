package 剑指offer;

import java.util.Stack;

/** 双栈维护一个辅助栈，辅助栈保存了历次最小的值*/
public class MinStack {
    /** initialize your data structure here. */

    private Stack<Integer> stack1;

    private Stack<Integer>stack2;


    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty() || stack2.peek() >= x) {
            stack2.push(x);
        }
    }

    public void pop() {
        Integer pop = stack1.pop();

        if (pop.equals(stack2.peek())) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
