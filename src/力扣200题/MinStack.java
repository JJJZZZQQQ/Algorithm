package 力扣200题;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack1 ;
    Stack<Integer> stack2 ;

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if(stack2.isEmpty() || val <= stack2.peek()) {
            stack2.push(val);
        }
    }

    public void pop() {
        Integer pop = stack1.pop();
        if(pop.equals(stack2.peek())) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
