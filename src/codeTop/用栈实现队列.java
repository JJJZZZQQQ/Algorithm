package codeTop;

import java.util.Stack;

public class 用栈实现队列 {
    class MyQueue {
        //暂存元素
        private Stack<Integer> stack1;
        //最后存放位置
        private Stack<Integer> stack2;

        public MyQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
